#
# @lc app=leetcode id=1893 lang=python3
#
# [1893] Check if All the Integers in a Range Are Covered
#

# @lc code=start
from typing import List
class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        #Brutal Force works fine
        # for i in range(left, right + 1):
        #     cnt = 0
        #     for r in ranges:
        #         if r[0] <= i <= r[-1]:
        #             cnt += 1
        #     if cnt == 0:
        #         return False
        #     else:
        #         continue
        # return True
    
        #Done by difference array:
        diff = [0] * 52
        for l, r in ranges:
            diff[l] += 1
            diff[r + 1] -= 1
        
        cur = 0
        
        for i in range(1, 51):
            cur += diff[i]
            if left <= i <= right and cur <= 0:
                return False
        return True
    

        
# @lc code=end

