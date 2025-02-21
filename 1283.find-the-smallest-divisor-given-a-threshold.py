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
        left = 1
        right = max(nums) 
        while left < right:
            mid = (left + right) // 2
            if sum(math.ceil(num / mid) for num in nums) > threshold:
                left = mid + 1
            else:
                right = mid
        return left


# @lc code=end

