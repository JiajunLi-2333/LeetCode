#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
import bisect
class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        return [-1,-1] if target not in nums else [bisect.bisect_left(nums, target), bisect.bisect_right(nums, target) -1]
# @lc code=end

