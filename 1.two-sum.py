#
# @lc app=leetcode id=1 lang=python
#
# [1] Two Sum
#

# @lc code=start
from collections import Counter
class Solution:
    def twoSum(self, nums, target):
        #Brute Force
        # Time complexity: O(n^2)
        # Space complexity: O(1)
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             ret
        

        #todo The technique of iterate the right and maintain the left
        # Time complexity: O(n)
        # Space complexity: O(n)

        #When we are traversing through the list, we are also storing the information that is ready to use for the left side
        hashmap = {}
        for i in range(len(nums)):
            if target - nums[i] in hashmap:
                return [hashmap[target - nums[i]], i]
            hashmap[nums[i]] = i
        
        #test for the linux
        return None 
# @lc code=end

