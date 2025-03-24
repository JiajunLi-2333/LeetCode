#
# @lc app=leetcode id=2390 lang=python3
#
# [2390] Removing Stars From a String
#

# @lc code=start
class Solution:
    def removeStars(self, s: str) -> str:
        ans = []
        for i in s:
            if i != '*':
                ans.append(i)
            else:
                ans.pop()
        return ''.join(ans)
        
# @lc code=end

