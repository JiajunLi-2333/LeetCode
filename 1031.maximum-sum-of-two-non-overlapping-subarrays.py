#
# @lc app=leetcode id=1031 lang=python3
#
# [1031] Maximum Sum of Two Non-Overlapping Subarrays
#

# @lc code=start
class Solution:
    def maxSumTwoNoOverlap(self, nums: list[int], firstLen: int, secondLen: int) -> int:
        preSum = [0] * (len(nums) + 1)
        for i in range(len(nums)):
            preSum[i + 1] = preSum[i] + nums[i]
        
        def maximum(L:int, R: int) -> int:
            ans = 0
            preMax = 0
            for i in range(L+R, len(preSum)):
                preMax = max(preMax, preSum[i - R] - preSum[i - L - R])
                ans = max(ans, preMax + preSum[i] - preSum[i - R])
            return ans
        
        return max(maximum(firstLen, secondLen), maximum(secondLen, firstLen))
# @lc code=end

