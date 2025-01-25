#
# @lc app=leetcode id=2779 lang=python3
#
# [2779] Maximum Beauty of an Array After Applying Operation
#

# @lc code=start
from collections import Counter
class Solution:
    def maximumBeauty(self, nums: list[int], k: int) -> int:
        #This is correct but TLE as nested for loop 
        # hashmap = Counter()
        # for i in range(len(nums)):
        #     for j in range(nums[i]- k, nums[i]+ k + 1):
        #         hashmap[j] += 1
        # return max(hashmap.values()) 

        #Optimized solution   
         sorted_nums = sorted(nums)
         left = 0
         length = 0
         for i in range(len(nums)):
            if sorted_nums[i] - sorted_nums[left] > 2 * k:
                left += 1
            length = max(length, i - left + 1)
         return length            
# @lc code=end

