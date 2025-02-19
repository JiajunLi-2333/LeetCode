#
# @lc app=leetcode id=2529 lang=python3
#
# [2529] Maximum Count of Positive Integer and Negative Integer
#

# @lc code=start
import bisect
class Solution:
    def maximumCount(self, nums: list[int]) -> int:
        #todo Iterate through the list and count the number of positive and negative numbers

        # pos = neg = 0
        # for num  in nums:
        #     if num > 0:
        #         pos += 1
        #     elif num < 0:
        #         neg += 1
        # return max(pos, neg)

        #todo Use binary search to find the first positive and negative numbers
        #Time Complexity: O(log n)
        #Space Complexity: O(1)
        neg = bisect.bisect_left(nums, 0)
        pos = len(nums) - bisect.bisect_right(nums, 0)
        return max(neg, pos) 


    
        
# @lc code=end

