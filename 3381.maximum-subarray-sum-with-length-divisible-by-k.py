#
# @lc app=leetcode id=3381 lang=python3
#
# [3381] Maximum Subarray Sum With Length Divisible by K
#
# @lc code=start
from math import inf 
class Solution:
    def maxSubarraySum(self, nums: list[int], k: int) -> int:
        #! Deriving the preSum array
        preSum = [0] * (len(nums) + 1)
        min_S = [inf] * k
        ans = - inf
        for i in range(len(nums)):
            preSum[i + 1] = preSum[i] + nums[i]
        for i, j in enumerate(preSum):
            remainder = i % k
            ans = max(ans, j - min_S[remainder])
            min_S[remainder] = min(min_S[remainder], j)
        return ans
# @lc code=end

