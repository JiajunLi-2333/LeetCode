#
# @lc app=leetcode id=2848 lang=python3
#
# [2848] Points That Intersect With Cars
#

# @lc code=start
from typing import List
from itertools import accumulate
class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        mx = max(end for _, end in nums) + 1
        diff = [0] * (mx + 1)
        for l, r in nums:
            diff[l] += 1
            diff[r + 1] -= 1
        cnt = 0
        for i in accumulate(diff):
            cnt += 1 if i > 0 else 0
        return cnt 
# @lc code=end

