#
# @lc app=leetcode id=2563 lang=python3
#
# [2563] Count the Number of Fair Pairs
#

# @lc code=start
import bisect
class Solution:
    def countFairPairs(self, nums: list[int], lower: int, upper: int) -> int:
        ans = 0
        nums.sort()
        for i in range(len(nums)):
            r = bisect.bisect_right(nums, upper - nums[i], 0, i)
            l = bisect.bisect_left(nums, lower - nums[i], 0, i)
            ans += r - l 
        return ans
# @lc code=end

