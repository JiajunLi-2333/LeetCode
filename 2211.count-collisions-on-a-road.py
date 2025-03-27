#
# @lc app=leetcode id=2211 lang=python3
#
# [2211] Count Collisions on a Road
#

# @lc code=start
class Solution:
    def countCollisions(self, directions: str) -> int:

        #use a stack to store the cars

        #Figure out the conditions of collisions is the key to the solution

        # RRRRLL
        # RRRSSL -> RRSSSL -> RSSSSL -> SSSSSL -> SSSSSS
        # 2 + 1 + 1 + 1 + 1 = 6 collisions

        #condition of collision:
        stack, ans = [], 0
        for d in directions:
            if not stack:
                stack.append(d)
            elif d == 'R':
                stack.append(d)
            elif d == 'S':
                while stack and stack[-1] == 'R':
                    stack.pop() 
                    ans += 1
                stack.append(d)
            #when d == 'L' 
            else:
                #the first L in the stack does not collide with any R or S
                if not stack:
                    continue
                elif stack[-1] == 'S':
                    ans += 1
                elif stack[-1] == 'R':
                    ans += 2
                    stack.pop()
                    while stack and stack[-1] == 'R':
                        stack.pop()
                        ans += 1
                    stack.append('S')
        return ans
        # stack = []
        # ans = 0
        
        # for n in directions:
        #     if not stack:
        #         stack.append(n)

        #     elif n == 'S':
        #         while stack and stack[-1] == 'R':
        #             ans += 1
        #             stack.pop()
        #         stack.append(n)
                
   
        #     elif n == 'R':
        #         stack.append(n)
                
       
        #     else:
        #         if not stack:
        #             continue
        #         elif stack[-1] == 'S':
        #             ans += 1 
        #         elif stack[-1] == 'R':
        #             ans += 2
        #             stack.pop()
        #             while stack and stack[-1] == 'R':
        #                 ans += 1
        #                 stack.pop()
        #             stack.append('S')
        # return ans


# @lc code=end

