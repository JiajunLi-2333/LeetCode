#
# @lc app=leetcode id=2064 lang=python3
#
# [2064] Minimized Maximum of Products Distributed to Any Store
#

# @lc code=start
from typing import List
import math
class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        # def check(maxAmount: int) -> bool:
        #     #check if distributing each store maxAmount of product, can we distribute all the products
        #     total = 0
        #     for q in quantities: 
        #         total += math.ceil(q / maxAmount)
        #     return total <= n

        def check(maxAmount: int ) -> bool:
            sum = 0
            for q in quantities: 
                # Ensure the correct amount of stores to be distributed 
                sum += ((q + maxAmount -1) // maxAmount)
            return sum <= n
        
        left = 0
        right = max(quantities)
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid
        return right

# @lc code=end

