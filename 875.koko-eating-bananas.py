#
# @lc app=leetcode id=875 lang=python3
#
# [875] Koko Eating Bananas
#

# @lc code=start
from typing import List
from math import ceil
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check(speed: int) -> bool:
            return sum(ceil(pile / speed) for pile in piles) <= h
        left, right = 1, max(piles)
        while left <= right:
            mid = (left + right) //2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left
    
# @lc code=end

