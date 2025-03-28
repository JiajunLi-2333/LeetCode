#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:

        #use stack to simulate the process
        stack = []
        for c in s:
            if c in '([{':
                stack.append(c)
            else:
                if not stack:
                    return False
                if stack[-1] == '(' and c == ')':
                    stack.pop()
                elif stack[-1] == '[' and c == ']':
                    stack.pop()
                elif stack[-1] == '{' and c == '}':
                    stack.pop()
                else:
                    return False
        return not stack
# @lc code=end

