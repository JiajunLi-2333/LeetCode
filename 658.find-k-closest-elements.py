#
# @lc app=leetcode id=658 lang=python3
#
# [658] Find K Closest Elements
#

# @lc code=start
class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        #use the eclusion method
        left, right = 0, len(arr) - 1
        if right - left == 0:
            return arr
        while (right - left + 1) > k: 
            if abs(arr[left] - x) <= abs(arr[right] - x):
                right -= 1
            else:
                left += 1
        return arr[left:right + 1]
# @lc code=end

