#
# @lc app=leetcode id=1760 lang=python3
#
# [1760] Minimum Limit of Balls in a Bag
#

# @lc code=start
from typing import List
from bisect import bisect_left
class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        def check(maxBalls: int) -> bool:
            ops = 0
            for num in nums:
                if num > maxBalls:
                    # -1 because I am counting number of operations to reduce the number of balls to maxBalls
                    ops += (num + maxBalls - 1) // maxBalls - 1
            return ops <= maxOperations
        left = 0
        right = max(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid
        return left + 1 
        
        
        # def check(m: int) -> bool:
        #     cnt = 0
        #     for x in nums:
        #         cnt += (x - 1) // m
        #     return cnt <= maxOperations
        # return bisect_left(range(max(nums)), True, 1, key=check)    
# @lc code=end

