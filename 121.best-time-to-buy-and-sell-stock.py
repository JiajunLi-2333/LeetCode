#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
from math import inf
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_price = inf
        ans = 0
        for price in prices:
            min_price = min(min_price, price)
            if price > min_price:
                ans = max(ans, price - min_price)
        return ans      
# @lc code=end

