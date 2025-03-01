#
# @lc app=leetcode id=275 lang=python3
#
# [275] H-Index II
#

# @lc code=start
from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left = 1
        right = len(citations)
        while left <= right:
            mid = (left + right) // 2
            # if citations[-mid] >= mid:
            #     left = mid + 1
            # else:
            #     right = mid - 1

            if citations[-mid] < mid:
                right = mid - 1
            else:
                left = mid + 1
        return right
# @lc code=end

