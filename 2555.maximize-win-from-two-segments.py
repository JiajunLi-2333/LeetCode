#
# @lc app=leetcode id=2555 lang=python3
#
# [2555] Maximize Win From Two Segments
#

# @lc code=start
from collections import Counter
class Solution:
    def maximizeWin(self, prizePositions: list[int], k: int) -> int:
        # n = len(prizePositions)
        # ans = left = 0
        # mx = [0] * (n + 1)
        # for right, p in enumerate(prizePositions):
        #     while p - prizePositions[left] > k:
        #         left += 1
        #     ans = max(ans, mx[left] + right - left + 1)
        #     mx[right + 1] = max(mx[right], right - left + 1)
        # return ans
        



        #todo redo it again to see if I improve my skills or not
        n = len(prizePositions)
        ans  = left = 0
        mx_num = [0] * (n + 1)
        for right, p in enumerate(prizePositions):
            while p - prizePositions[left] > k:
                left += 1
            ans = max(ans, mx_num[left] + right - left + 1)
            mx_num[right + 1] = max(mx_num[right], right - left + 1)
        return ans
# @lc code=end

