#
# @lc app=leetcode id=2696 lang=python3
#
# [2696] Minimum String Length After Removing Substrings
#

# @lc code=start
class Solution:
    def minLength(self, s: str) -> int:
        # Use a stack to store the characters
        # the top two characters in the stack should be checked

        #Every time we add a character to the stack, we check if the last two characters in the stack form a forbidden string. If they do, we remove them from the stack.

        #use the combination of for loop and while loop as the solution

        # stack = []
        # forbidden = ["AB", "CD"]
        # for c in s:
        #     stack.append(c)
        #     while len(stack) >= 2 and ''.join(stack[-2:]) in forbidden:
        #         stack.pop()
        #         stack.pop()
        # return len(stack)

        st = []
        for c in s:
            if st and (c == 'B' and st[-1] == 'A' or c == 'D' and st[-1] == 'C'):
                st.pop()
            else:
                st.append(c)
        return len(st)
# @lc code=end

