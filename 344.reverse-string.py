#
# @lc app=leetcode id=344 lang=python3
#
# [344] Reverse String
#

# @lc code=start
from typing import List
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left, right = 0, len(s) - 1
        while left < right:
            #do the swap

            #This is the python tuple unpacking
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1


        
# @lc code=end

