#
# @lc app=leetcode id=704 lang=python3
#
# [704] Binary Search
#

# @lc code=start
import bisect 
class Solution:
    def search(self, nums: list[int], target: int) -> int:
        return -1 if target not in nums else bisect.bisect_left(nums, target)
        
# @lc code=end

