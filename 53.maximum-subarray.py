#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
from math import inf
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        preSum = 0
        min_preSum = 0
        ans = - inf
        for i in range(len(nums)):
            preSum += nums[i]
            ans = max(ans, preSum - min_preSum)
            min_preSum = min(min_preSum, preSum)
        return ans     
# @lc code=end

