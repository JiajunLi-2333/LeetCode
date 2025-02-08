#
# @lc app=leetcode id=2001 lang=python3
#
# [2001] Number of Pairs of Interchangeable Rectangles
#

# @lc code=start
from collections import Counter
class Solution:
    def interchangeableRectangles(self, rectangles: list[list[int]]) -> int:
        hashmap = Counter()
        ans = 0
        for rect in rectangles:
            ratio = rect[0] / rect[1]
            ans += hashmap[ratio]
            hashmap[ratio] += 1 
        return ans


        
# @lc code=end

