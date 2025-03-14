#
# @lc app=leetcode id=1109 lang=python3
#
# [1109] Corporate Flight Bookings
#

# @lc code=start
from typing import List
from itertools import accumulate
class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        diff = [0] * (n + 2)
        for first, last, seats in bookings:
            diff[first] += seats
            diff[last + 1] -= seats
        ans = list(accumulate(diff[1:n + 1]))
        return ans

        
# @lc code=end

