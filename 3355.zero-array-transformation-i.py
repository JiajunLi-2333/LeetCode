#
# @lc app=leetcode id=3355 lang=python3
#
# [3355] Zero Array Transformation I
#

# @lc code=start
from typing import List
from itertools import accumulate
class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        diff = [0] * (len(nums) + 1)
        for start, end in queries:
            diff[start] += 1
            diff[end + 1] -= 1
        
        for x, sum_ in zip(nums, accumulate(diff)):
            if x > sum_:
                return False
        return True
        
# @lc code=end

