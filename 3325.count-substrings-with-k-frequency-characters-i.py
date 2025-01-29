#
# @lc app=leetcode id=3325 lang=python3
#
# [3325] Count Substrings With K-Frequency Characters I
#

# @lc code=start
from collections import Counter
class Solution:
    def numberOfSubstrings(self, s: str, k: int) -> int:
        # hashmap = Counter()
        # left, ans = 0, 0
        # for i in range(len(s)):
        #     hashmap[s[i]] += 1
        #     while hashmap[s[i]] == k:
        #         hashmap[s[left]] -= 1
        #         left += 1
        #     ans += left
        # return ans
        hashmap = Counter()
        left, ans = 0, 0
        for i in range(len(s)):
            hashmap[s[i]] += 1
            while hashmap[s[i]] == k:
                hashmap[s[left]] -= 1
                left += 1
                if hashmap[s[i]] == k - 1:
                    ans += (left - 0 + len(s) - 1 - i)
                    break
        return ans -1
# @lc code=end

