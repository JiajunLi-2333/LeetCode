#
# @lc app=leetcode id=35 lang=python3
#
# [35] Search Insert Position
#

# @lc code=start
import bisect
class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        #Right and left points to the same position
        def binary_search(nums: list[int], target: int) -> int:
            left = 0
            right = len(nums)
            while left < right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            return left
        return binary_search(nums, target)
# @lc code=end

