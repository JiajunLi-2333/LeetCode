#
# @lc app=leetcode id=1749 lang=python3
#
# [1749] Maximum Absolute Sum of Any Subarray
#

# @lc code=start
class Solution:
    def maxAbsoluteSum(self, nums: list[int]) -> int:
        prefix = [0] * (len(nums) + 1)
        for i, c in enumerate(nums):
            prefix[i + 1] = prefix[i] + c
        return abs(max(prefix) - min(prefix))
# @lc code=end

