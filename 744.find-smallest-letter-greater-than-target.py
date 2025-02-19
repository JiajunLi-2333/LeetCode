#
# @lc app=leetcode id=744 lang=python3
#
# [744] Find Smallest Letter Greater Than Target
#

# @lc code=start
class Solution:
    def nextGreatestLetter(self, letters: list[str], target: str) -> str:

        #todo Using the binary search algorithm
        left, right = 0, len(letters) - 1

        while left <= right:
            mid = (left + right) // 2
            if letters[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1
        
        return letters[left] if left < len(letters) else letters[0] 
        # for letter in letters:
        #     if letter > target:
        #         return letter
        # return letters[0]
        
# @lc code=end

