#
# @lc app=leetcode id=2009 lang=python3
#
# [2009] Minimum Number of Operations to Make Array Continuous
#

# @lc code=start
from typing import List
class Solution:
    def minOperations(self, nums: List[int]) -> int:

        # all elements in nums must be unique
        # the diff between max and min in nums == len(nums) - 1 

        #constraints 1 <= nums[i] <= 10 ** 9 

        #The key is to find the maximum number of elements that we can keep in the array
        a = sorted(set(nums))
        ans = -1
        left = 0
        for i, x in enumerate(a):
            while a[left] < x - len(nums) + 1:
                left += 1
            ans = max(ans, i - left + 1)
        #how many elements we need to change
        return len(nums) - ans    
# @lc code=end

