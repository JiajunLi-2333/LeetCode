#
# @lc app=leetcode id=1482 lang=python3
#
# [1482] Minimum Number of Days to Make m Bouquets
#

# @lc code=start
from typing import List
class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def check(days: int) -> bool:
            bonquests = 0
            left = 0
            for i in range(len(bloomDay)):
                if bloomDay[i] > days:
                    left = i + 1
                if i - left + 1 == k:
                    bonquests += 1
                    left = i + 1
            return bonquests >= m
        if len(bloomDay) < m * k:
            return -1
        left = 0
        right = max(bloomDay)
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left


# @lc code=end

