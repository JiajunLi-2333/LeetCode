#
# @lc app=leetcode id=2594 lang=python3
#
# [2594] Minimum Time to Repair Cars
#

# @lc code=start
from typing import List
from math import isqrt
class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        def check(time: int) -> bool:
            total = 0
            for rank in ranks:
                total += isqrt(time // rank)
            if total >= cars:
                return True
            return False
        left = 0
        right = max(ranks) * cars * cars
        while left <= right:
            mid = (left + right) //2
            if check(mid):
                right = mid -1
            else:
                left = mid + 1
        return left

# @lc code=end

