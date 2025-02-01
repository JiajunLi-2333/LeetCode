#
# @lc app=leetcode id=1744 lang=python3
#
# [1744] Can You Eat Your Favorite Candy on Your Favorite Day?
#

# @lc code=start
import itertools
class Solution:
    def canEat(self, candiesCount: list[int], queries: list[list[int]]) -> list[bool]:
        # ans = []
        # preSum = [0] * (len(candiesCount)  +1)
        # for i in range(len(candiesCount)):
        #     preSum[i + 1] = preSum[i] + candiesCount[i]
        # for query in queries:
        #     need_lower = preSum[query[0]] + 1
        #     need_upper = preSum[query[0] + 1]
        #     lb = query[1] + 1
        #     ub = (query[1] + 1) * query[2]
        #     if need_upper < lb or need_lower > ub:
        #         ans.append(False)
        #     else:
        #         ans.append(True)
        # return ans   
        # 
        #todo Optimized solution from LeeCode
        A = [0] + list(itertools.accumulate(candiesCount))
        return [A[t] // c <= d < A[t + 1] for t, d, c in queries]
         
# @lc code=end

