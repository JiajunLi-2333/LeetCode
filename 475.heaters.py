#
# @lc app=leetcode id=475 lang=python3
#
# [475] Heaters
#

# @lc code=start
from typing import List
import bisect 
class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        def check(radius: int) -> bool:
            j = 0
            m = len(heaters)
            for i in range(len(houses)):
                while (j < m and houses[i] > heaters[j] + radius):
                    j += 1
                if j < m and abs(houses[i] - heaters[j]) <= radius:
                    continue
                else:
                    return False
            return True
        
        houses.sort()
        heaters.sort()
        left = 0
        right = max(houses[-1], heaters[-1]) - min(houses[0], heaters[0])
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1 
        return left 

# @lc code=end

