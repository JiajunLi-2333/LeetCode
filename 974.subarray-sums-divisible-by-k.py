#
# @lc app=leetcode id=974 lang=python3
#
# [974] Subarray Sums Divisible by K
#

# @lc code=start
from collections import Counter
class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        count = Counter({0: 1})
        prefix = 0
        ans = 0
        for num in nums:
            prefix = (prefix + num) %k
            ans += count[prefix]
            count[prefix] += 1
        return ans
# @lc code=end

