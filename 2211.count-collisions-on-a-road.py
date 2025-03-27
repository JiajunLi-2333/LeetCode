#
# @lc app=leetcode id=2211 lang=python3
#
# [2211] Count Collisions on a Road
#

# @lc code=start
class Solution:
    def countCollisions(self, directions: str) -> int:

        #use a stack to store the cars

        #condition of collision:
        stack, ans = [], 0
        for d in directions:
            if stack and stack[-1] == 'R':
                if d == 'L':
                    stack.append('S')
                    ans += 2
                elif d == 'S':
                    stack.append('S')
                    ans += 1
            elif stack and stack[-1] == 'S':
                if d == 'L':
                    #change the last car to 'S'
                    stack.append('S')
                    ans += 1
                else:
                    stack.append(d)
            else:
                stack.append(d)
        return ans


# @lc code=end

