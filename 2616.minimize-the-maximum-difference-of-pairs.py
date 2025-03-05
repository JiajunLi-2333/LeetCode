#
# @lc app=leetcode id=2616 lang=python3
#
# [2616] Minimize the Maximum Difference of Pairs
#

# @lc code=start
from typing import List
class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        nums.sort()
        def pairs(maxdiff: int) -> int:
            #Find the number of pairs with the maximum difference less than or equal to maxdiff
            count = 0 
            i = 0
            n = len(nums) 
            while i < n -1:
                if nums[i + 1] - nums[i] <= maxdiff:
                    count += 1
                    i += 2
                else:
                    i += 1
            return count
        left, right = -1, nums[-1] - nums[0]
        while left + 1 < right:
            mid = (left + right) // 2
            #if the number of pairs with the maxdiff is greater than p, this means that the maxdiff is too big that we need to reduce it
            if pairs(mid) >= p:
                right = mid
            else:
            #otherwise, need to increase the maxdiff so that we can have more pairs with the maxdiff
                left = mid
        return right
# @lc code=end

