#
# @lc app=leetcode id=523 lang=python3
#
# [523] Continuous Subarray Sum
#

# @lc code=start
from collections import Counter
class Solution:
    #todo Prefix Sum, hashmap and Reminder Mathematical Property
    def checkSubarraySum(self, nums: list[int], k: int) -> bool:
        #This is actually the index of the remainder, you can also call it reminder cache
        index_map = Counter({0: -1})
        prefix = 0
        for i in range(len(nums)):
            prefix += nums[i]
            remainder = prefix % k
            if remainder not in index_map:
                index_map[remainder] = i
            elif i - index_map[remainder] > 1:
                return True
        return False   
# @lc code=end

