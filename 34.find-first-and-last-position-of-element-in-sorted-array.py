#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
import bisect
class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:

        #Use Binary Search to find the position of the first occurence

        def find_first_one(nums: list[int], target: int) -> int:
            #This a closed region [left, right] both inclusive
            left = 0
            right = len(nums) -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                if nums[mid] >= target:
                    right = mid - 1
            return left
        
        def find_first_two(nums: list[int], target: int) -> int:
            #Now Right and Left points to the same position
            left = 0
            right = len(nums)
            while left < right:
                mid = (left + right)//2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            return left
        
        def find_first_three(nums: list[int], target: int) -> int:
            #Now R points to the first position of the target
            #Left is on the left side of R
            left = -1
            right = len(nums)
            while left + 1 > right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid
                else:
                    right = mid
            return right # or return left + 1
        return [-1,-1] if target not in nums else [find_first_one(nums, target), find_first_one(nums, target + 1) -1]
        #! Below is the solution using the written module bisect, not really recommend to use it in interview
        # return [-1,-1] if target not in nums else [bisect.bisect_left(nums, target), bisect.bisect_right(nums, target) -1]
# @lc code=end

