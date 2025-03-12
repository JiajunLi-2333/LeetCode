#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#

# @lc code=start
from typing import List
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # Distance * height
        # Find Max Area

        #Strategy:
        #Area: Min(heights) * distance
        #! TLE
        # ans = 0
        # for i in range(len(height)):
        #     k = len(height) - 1
        #     while i < k :
        #         ans = max(ans, min(height[i], height[k]) * (k - i))
        #         k -= 1
        # return ans
            
        #Optimized
        #Two Pointer Approach
        j = 0
        k = len(height) - 1
        ans = 0 
        while j < k:
            ans = max(ans, min(height[j], height[k]) * (k - j))
            if height[j] < height[k]:
                j += 1
            else:
                k -= 1
        return ans
        
# @lc code=end

