#
# @lc app=leetcode id=3090 lang=python3
#
# [3090] Maximum Length Substring With Two Occurrences
#

# @lc code=start
from collections import Counter 
class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        hashmap = Counter()
        left = 0
        ans = 0 
        for i, c in enumerate(s):
            hashmap[c] += 1
            if hashmap[c] > 2:
                while hashmap[c] > 2:
                    hashmap[s[left]] -= 1
                    left += 1
            ans = max(ans, i - left  +1)
        return ans   
# @lc code=end

