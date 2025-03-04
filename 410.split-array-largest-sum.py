#
# @lc app=leetcode id=410 lang=python3
#
# [410] Split Array Largest Sum
#

# @lc code=start
from typing import List
class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def check(maxSum: int) -> bool:
            count = 1
            sum = 0
            for num in nums:
                if num > maxSum:
                    return False
                if sum + num > maxSum:
                    if count == k:
                        return False
                    count += 1
                    sum = num
                else:
                    sum += num
            return True
        right = sum(nums) 
        left = min(nums) -1
        while left + 1 < right:
            mid = (left + right) //2
            if check(mid):
                right = mid
            else:
                left = mid
        return right
# @lc code=end

