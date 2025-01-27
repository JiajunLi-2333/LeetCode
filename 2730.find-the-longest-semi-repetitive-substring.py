#
# @lc app=leetcode id=2730 lang=python3
#
# [2730] Find the Longest Semi-Repetitive Substring
#

# @lc code=start
class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        # i = cur = 0
        # for j in range(1, len(s)):
        #     cur += s[j] == s[j - 1]
        #     if cur > 1:
        #         i += 1
        #         cur -= s[i] == s[i - 1]
        # return len(s) - i  


        # ans = 1
        # left = 0
        # last = 0
        # for i in range(1, len(s)):
        #     if s[i] == s[i - 1]:
        #         if last != 0: 
        #             left = last
        #         last = i
        #     ans = max(ans, i - left  +1)
        # return ans


        #ans = 1
        # i = 0
        # j = 1
        # last = 0

        # while j < len(s):
        #     if s[j] == s[j - 1]:  # Check if the current character is the same as the previous one
        #         if last != 0:
        #             i = last  # Update `i` only for the first duplicate
        #         last = j  # Update `last` to the current position
        #     ans = max(ans, j - i + 1)  # Update the max length
        #     j += 1

        # return ans

        pair_index = []
        pair_count, ans, left = 0, 0, 0
        if len(s) == 1:
            return 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                pair_count += 1
                pair_index.append(i)
                if pair_count > 1:
                    left = pair_index.pop(0)
                    pair_count -= 1
            ans = max(ans, i - left + 1)
        return ans

# @lc code=end

