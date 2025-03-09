#
# @lc app=leetcode id=2781 lang=python3
#
# [2781] Length of the Longest Valid Substring
#

# @lc code=start
from typing import List
class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        # substring of word is valid if it does not contain any forbidden string
        # find the longest valid substring
        
        #remove all the duplicated forbidden strings
        forbidden = set(forbidden)
        ans = left = 0
        for right in range(len(word)):
            for i in range(right, max(right - 10, left -1), -1):
                if word[i: right + 1] in forbidden:
                    left = i + 1
                    break
            ans = max(ans, right - left + 1)
        return ans
        
# @lc code=end

