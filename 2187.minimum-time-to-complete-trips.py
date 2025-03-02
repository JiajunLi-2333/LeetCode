#
# @lc app=leetcode id=2187 lang=python3
#
# [2187] Minimum Time to Complete Trips
#

# @lc code=start
from typing import List
class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        #todo treat left and right as the value of the time_range directly

        #This is the case left - 1 always < threshold regardless of the value of left and right + 1 always >= threshold regardless of the value of right 
        # left = min(time) #min(time) - 1 is always < threshold
        # right = min(time) * totalTrips - 1
        # while left <= right:
        #     mid = (left + right ) // 2
        #     if sum(mid // t for t in time) >= totalTrips:
        #         right = mid - 1
        #     else:
        #         left = mid + 1
        # return left

        #This is the case where left - 1 always < threshold regardless of the value of left and right along with right + 1 always >= threshold 
        # left = min(time)
        # right = min(time) * totalTrips
        # while left < right:
        #     mid = (left + right) // 2
        #     if sum(mid // t for t in time) >= totalTrips:
        #         right = mid
        #     else:
        #         left = mid + 1
        # return right or return left

        #This is the case when left and left - 1 always < threshold and right and right + 1 always >= threshold
        left = min(time) - 1
        right = min(time) * totalTrips
        while left + 1 < right:
            mid = (left + right) // 2
            if sum(mid // t for t in time) >= totalTrips:
                right = mid
            else:
                left = mid
        return left + 1



        #! The problem of using left and right as index is that you need an array first to store the time_range and then use the index to get the value and this may trigger the memory limit exceeded error so it is better to treat left and right as the value of the time_range directly
        # time_range = list(range(min(time) * totalTrips + 1))
        # left = 0
        # right = len(time_range) - 1
        # while left <= right:
        #     mid = (left + right) // 2
        #     if sum(mid // t for t in time) >= totalTrips:
        #         right = mid - 1
        #     else:
        #         left = mid + 1
        # return time_range[left]
# @lc code=end

