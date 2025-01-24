#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
from collections import Counter
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = Counter()
        left  = 0
        ans = 0
        for i, c in enumerate(s):
            last_occr = hashmap.get(c, -1)
            hashmap[c] = i
            if last_occr >= left:
                left = last_occr + 1 
            ans = max(ans, i - left + 1)
        return ans
# @lc code=end

