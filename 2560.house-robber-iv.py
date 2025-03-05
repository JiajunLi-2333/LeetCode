#
# @lc app=leetcode id=2560 lang=python3
#
# [2560] House Robber IV
#

# @lc code=start
from typing import List
class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        def check(capability: int) -> bool:
            houses = 0
            n = len(nums)
            i = 0
            #correct logic of skipping the house
            while i < n:
                if nums[i] <= capability:
                    houses += 1
                    i = i + 2
                else:
                    i += 1
            return houses >= k
 
        left = min(nums) - 1
        right = max(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid
        return right

# @lc code=end

