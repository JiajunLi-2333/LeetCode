#
# @lc app=leetcode id=2576 lang=python3
#
# [2576] Find the Maximum Number of Marked Indices
#

# @lc code=start
from typing import List
class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        left = 0
        right = len(nums) // 2 + 1
        while left + 1 < right:
            mid = (left + right) //2
            if all(nums[i] * 2 <= nums[len(nums) + i - mid] for i in range(mid)):
                left = mid
            else:
                right = mid
        return left * 2

        
        
# @lc code=end

