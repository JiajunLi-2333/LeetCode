#
# @lc app=leetcode id=704 lang=python3
#
# [704] Binary Search
#

# @lc code=start
import bisect 
class Solution:
    def search(self, nums: list[int], target: int) -> int:
        #right pointer at the position, left pointer at left of the right pointer
        def binary_search(nums: list[int], target: int) -> int:
            left, right = -1, len(nums)
            while left + 1 < right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid
                else:
                    right = mid
            return right 
        return -1 if target not in nums else binary_search(nums, target)
        # return -1 if target not in nums else bisect.bisect_left(nums, target)
        
# @lc code=end

