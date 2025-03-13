#
# @lc app=leetcode id=1094 lang=python3
#
# [1094] Car Pooling
#

# @lc code=start
from typing import List
from itertools import accumulate
class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        difference_array = [0] * 1001
        for trip in trips:
            passenger = trip[0]
            from_ = trip[1]
            to = trip[2]
            difference_array[from_] += passenger
            difference_array[to] -= passenger

        for i in accumulate(difference_array):
            if i > capacity:
                return False
        return True       
# @lc code=end

