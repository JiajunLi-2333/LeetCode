#
# @lc app=leetcode id=1854 lang=python3
#
# [1854] Maximum Population Year
#

# @lc code=start
from typing import List
class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        #Constraint:
        # 1950 <= birthi < deathi <= 2050
        diff = [0] * 101
        for birth, death in logs:
            diff[birth - 1950] += 1
            diff[death - 1950] -= 1
        mx = 0
        ans = 0
        cur = 0
        for i in range(101):
            cur += diff[i]
            if cur > mx:
                mx = cur
                ans = i
        return ans + 1950

        
# @lc code=end

