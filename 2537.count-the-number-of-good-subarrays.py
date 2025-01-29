#
# @lc app=leetcode id=2537 lang=python3
#
# [2537] Count the Number of Good Subarrays
#

# @lc code=start
from collections import Counter
class Solution:
    def countGood(self, nums: list[int], k: int) -> int:
        hashmap = Counter()
        res = 0
        left = 0
        for i in range(len(nums)):
            k -= hashmap[nums[i]]
            hashmap[nums[i]] += 1
            while k <= 0:
                hashmap[nums[left]] -= 1
                k += hashmap[nums[left]]
                left += 1
            res += left
        return res

        
        
# @lc code=end

