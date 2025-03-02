#
# @lc app=leetcode id=2226 lang=python3
#
# [2226] Maximum Candies Allocated to K Children
#

# @lc code=start
from typing import List
import bisect
class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        # Stop give me stupid answers copilot!!!
        def check(num: int) -> bool:
            count = 0
            for i in range(len(candies)):
                count += candies[i] // num
            return count >= k
        
        left = 1
        right = max(candies) + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return 0 if sum(candies) < k else left
# @lc code=end

