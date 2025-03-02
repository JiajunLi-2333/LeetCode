#
# @lc app=leetcode id=1283 lang=python3
#
# [1283] Find the Smallest Divisor Given a Threshold
#

# @lc code=start
import math
from typing import List 
class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        #! This is the case when left ansd right points to the answer
        # left = 1
        # right = max(nums) 
        # while left < right:
        #     mid = (left + right) // 2
        #     if sum(math.ceil(num / mid) for num in nums) > threshold:
        #         left = mid + 1
        #     else:
        #         right = mid
        # return left

        #todo This is the case when left points to the answer and right is on the left side of the left pointer
        # left = 1
        # right = max(nums) - 1
        # while left <= right:
        #     mid = (left + right) // 2
        #     if sum(math.ceil(num / mid) for num in nums) > threshold:
        #         left = mid + 1
        #     else:
        #         right = mid - 1
        # return right + 1

        #todo This is the case when right points to the answer and left is on the left side of the right pointer
        right = max(nums)
        left = 0
        while left + 1 < right:
            mid = (left + right) // 2
            if sum(math.ceil(num / mid) for num in nums) > threshold:
                left = mid
            else:
                right = mid
        return left + 1

        


# @lc code=end

