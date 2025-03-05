#
# @lc app=leetcode id=3281 lang=python3
#
# [3281] Maximize Score of Numbers in Ranges
#

# @lc code=start
from typing import List
from math import inf
class Solution:
    def maxPossibleScore(self, start: List[int], d: int) -> int:
        start.sort() 
        def check(mi: int) -> bool:
            x = -inf
            for s in start:
                x = max(mi + x, s)
                if x > s + d:
                    return False
            return True
        left = 0
        right = (start[-1] + d - start[0]) + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left        
# @lc code=end

