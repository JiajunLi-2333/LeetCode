#
# @lc app=leetcode id=1750 lang=python3
#
# [1750] Minimum Length of String After Deleting Similar Ends
#

# @lc code=start
class Solution:
    def minimumLength(self, s: str) -> int:
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] == s[right]:
                while left + 1 < right and s[left + 1] == s[right]:
                    left += 1
                while right -1 > left and s[right -1] == s[left]:
                    right -= 1
            else:
                break
            left += 1
            right -= 1
        return right - left + 1
            
# @lc code=end

