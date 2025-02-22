#
# @lc app=leetcode id=1870 lang=python3
#
# [1870] Minimum Speed to Arrive on Time
#

# @lc code=start
from typing import List
import math
class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        left = 1
        right = 10**7
        hour = float(hour)
        def check(speed: int) -> bool:
            time = 0
            for i in range(len(dist) - 1):
                time += math.ceil(dist[i] / speed)
            time += float(dist[-1] / speed)
            return time <= hour
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left if check(left) else -1
# @lc code=end

