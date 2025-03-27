#
# @lc app=leetcode id=1717 lang=python3
#
# [1717] Maximum Score From Removing Substrings
#

# @lc code=start
class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        stack_one = []
        stack_two = []
        ans = 0

        #two stacks and greedy     
        #x: ab y: ba

        if x > y:
            for c in s:
                #remove all ab first 
                if stack_one and c == 'b' and stack_one[-1] == 'a':
                    ans += x
                    stack_one.pop()
                else:
                    stack_one.append(c)
            s2 = ''.join(stack_one)
            for c in s2:
                if stack_two and c == 'a' and stack_two[-1] == 'b':
                    ans += y
                    stack_two.pop()
                else:
                    stack_two.append(c)
        else:
            for c in s:
                if stack_two and c == 'a' and stack_two[-1] == 'b':
                    ans += y
                    stack_two.pop()
                else:
                    stack_two.append(c)
            s2 = ''.join(stack_two)
            for c in s2:
                if stack_one and c == 'b' and stack_one[-1] == 'a':
                    ans += x
                    stack_one.pop()
                else:
                    stack_one.append(c)
        return ans
            

# @lc code=end

