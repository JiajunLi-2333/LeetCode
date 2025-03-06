#
# @lc app=leetcode id=2517 lang=python3
#
# [2517] Maximum Tastiness of Candy Basket
#

# @lc code=start
from typing import List
class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()
        # 1 2 5 8 13 21 
        #Check function is always a pain in the ass for binary search problems
        def check(minDiff: int) -> int:
            cnt = 1
            i = j = 0
            n = len(price)
            while i < n:
                if price[i] - price[j] >= minDiff:
                    cnt += 1
                    j = i
                i += 1
            return cnt             
        left = 0
        right = price[-1] - price[0] + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid) >= k:
                left = mid
            else:
                right = mid
        return left
        
# @lc code=end

