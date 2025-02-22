#
# @lc app=leetcode id=1011 lang=python3
#
# [1011] Capacity To Ship Packages Within D Days
#

# @lc code=start
from typing import List
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int: 
        #Use a sliding window to find the days needed for a given capacity
        def check(capacity: int) -> bool:
            sum = day = 0
            for i in range(len(weights)):
                sum += weights[i]
                if sum > capacity:
                    day += 1 
                    sum = weights[i]
            return day + 1 <= days
        left, right = max(weights), sum(weights)
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left

# @lc code=end

