#
# @lc app=leetcode id=3371 lang=python3
#
# [3371] Identify the Largest Outlier in an Array
#

# @lc code=start
from typing import List
from collections import Counter
from math import inf
class Solution:
    def getLargestOutlier(self, nums: List[int]) -> int:
        # In nums array, one element is the sum of special numbers and one element is the outlier. The rest are special numbers
        # Special numbers, sum of Special numbers, outlier must have distinct indices but may have the same value

        # Constraints:
        # 3 <= len(nums) <= 10^5
        # -1000 <= nums[i] <= 1000
        # At least One outlier is garanteed

        #Goal: Largest Outlier

        #Strategy: 

        ans = -inf
        hashmap = Counter(nums)
        total = sum(nums)
        for num in nums:
            hashmap[num] -= 1
            if (total - num) % 2  == 0 and (hashmap[(total - num) // 2] > 0):
                ans = max(ans, num)
            hashmap[num] += 1
        return ans
        
        
# @lc code=end

