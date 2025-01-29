#
# @lc app=leetcode id=1358 lang=python3
#
# [1358] Number of Substrings Containing All Three Characters
#

# @lc code=start
from collections import Counter
class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        left, ans = 0, 0
        hashmap = Counter()
        for i in range(len(s)):
            hashmap[s[i]] += 1

            while len(hashmap) == 3:
                hashmap[s[left]] -= 1
                if hashmap[s[left]] == 0:
                    del hashmap[s[left]]
                left += 1

            ans += left
        return ans
# @lc code=end

