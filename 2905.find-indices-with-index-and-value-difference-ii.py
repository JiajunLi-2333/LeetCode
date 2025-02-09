#
# @lc app=leetcode id=2905 lang=python3
#
# [2905] Find Indices With Index and Value Difference II
#

# @lc code=start
from collections import Counter
from math import inf
class Solution:
    def findIndices(self, nums: list[int], indexDiff: int, valueDiff: int) -> list[int]:
        #! TLE stupid solution
        # hashmap = Counter()
        # if indexDiff == 0 and valueDiff == 0:
        #     return [0, 0]
        # for i, num in enumerate(nums):
        #     for key in hashmap:
        #         if abs(num - key) >= valueDiff and abs(i - hashmap[key]) >= indexDiff:
        #             return [hashmap[key], i]
        #     if num not in hashmap:
        #         hashmap[num] = i 
        # return [-1,-1]      

        #todo optimize: What if I keep the index of i always <= j - indexDiff
        #? I was very close to the solution, but I missed the fact that I can keep the index of i always <= j - indexDiff
        max_index = min_index = 0
        for i in range(indexDiff, len(nums)):
            cur_index = i - indexDiff
            if nums[cur_index] > nums[max_index]:
                max_index = cur_index
            elif nums[cur_index] < nums[min_index]:
                min_index = cur_index
            
            if nums[max_index] - nums[i] >= valueDiff:
                return [max_index, i]
            if nums[i] - nums[min_index] >= valueDiff:
                return [min_index, i]
        return [-1, -1]
# @lc code=end

