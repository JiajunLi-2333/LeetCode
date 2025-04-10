#
# @lc app=leetcode id=3296 lang=python3
#
# [3296] Minimum Number of Seconds to Make Mountain Height Zero
#

# @lc code=start
from typing import List
from math import isqrt
class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def check(time_limit: int) -> bool:
            distance = 0
            for t in workerTimes:
                distance += ((isqrt(1 + 8 * time_limit//t)) - 1)//2
            if distance >= mountainHeight:
                return True
            return False
        
        left = 0
        #the right bound is the maximum time needed to make the mountain height zero
        right = ((mountainHeight + 1) * mountainHeight)//2 * max(workerTimes)
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1 
            else:
                left = mid + 1
        return left
# @lc code=end

