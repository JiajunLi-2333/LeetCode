#
# @lc app=leetcode id=1642 lang=python3
#
# [1642] Furthest Building You Can Reach
#

# @lc code=start
from typing import List
class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        #Check if we can each the building
        def check(bidx: int) -> bool:
            #Get the height difference between the buildings
            diff = [d for d in Height_diff[:bidx] if d > 0]
            diff.sort(reverse=True)
            #Check if we can reach the building
            #use ladder for the largest height difference
            #use bricks for the rest
            return sum(diff[ladders:]) <= bricks



        Height_diff = []
        for i in range(len(heights) - 1):
            Height_diff.append(heights[i+1] - heights[i])

        left, right = 0, len(heights) 
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid 
            else:
                right = mid 
        return left
        


# @lc code=end

