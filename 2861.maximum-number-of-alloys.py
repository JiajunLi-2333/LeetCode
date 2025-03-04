#
# @lc app=leetcode id=2861 lang=python3
#
# [2861] Maximum Number of Alloys
#

# @lc code=start
from typing import List
class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int], cost: List[int]) -> int:
        def check(alloy_num: int) -> bool:
            #todo 1.check if any machine can produce alloy_num alloys within the budget range
            for comp in composition:
                total_cost = 0
                for i, j, k in zip(comp, stock, cost):
                    if j < alloy_num * i:
                        total_cost += (i*alloy_num - j) * k
                    else: 
                        continue
                if total_cost <= budget:
                    return True
            #If no machine can produce alloy_num alloys within the budget range, return False
            return False
        left = 0
        right = max(stock) + budget + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left

        
        
# @lc code=end

