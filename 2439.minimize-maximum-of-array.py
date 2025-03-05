#
# @lc app=leetcode id=2439 lang=python3
#
# [2439] Minimize Maximum of Array
#

# @lc code=start
from typing import List
class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        def check(maxNum: int) -> bool:
            #check if we can make all elements less than or equal to this maxNum with unlimited operations
            temp = nums.copy() 
            for i in range(len(temp)-1, 0, -1):
                need = 0
                if temp[i] > maxNum:
                    need = temp[i] - maxNum
                    temp[i - 1] += need
            return temp[0] <= maxNum
        
        left = min(nums) - 1
        right = max(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid
        return right
        
                

# @lc code=end

