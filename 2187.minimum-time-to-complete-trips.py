#
# @lc app=leetcode id=2187 lang=python3
#
# [2187] Minimum Time to Complete Trips
#

# @lc code=start
from typing import List
class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        left = min(time) - 1
        right = min(time) * totalTrips
        while left <= right:
            mid = (left + right ) // 2
            if sum(mid // t for t in time) >= totalTrips:
                right = mid - 1
            else:
                left = mid + 1
        return left
# @lc code=end

