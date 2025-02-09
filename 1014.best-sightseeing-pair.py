#
# @lc app=leetcode id=1014 lang=python3
#
# [1014] Best Sightseeing Pair
#

# @lc code=start
class Solution:
    def maxScoreSightseeingPair(self, values: list[int]) -> int:
        preMax = values[0] + 0
        ans = 0
        for i, c in enumerate(values[1:], 1):
            ans = max(ans, preMax + c - i)
            preMax = max(preMax, c + i)
        return ans
# @lc code=end

