#
# @lc app=leetcode id=2506 lang=python3
#
# [2506] Count Pairs Of Similar Strings
#

# @lc code=start
from collections import Counter
class Solution:
    def similarPairs(self, words: list[str]) -> int:
        ans = 0
        hashmap = Counter()
        for word in words:
            #This can be used as a key in the hashmap
            key = frozenset(word)
            ans += hashmap[key]
            hashmap[key] += 1
        return ans

# @lc code=end

