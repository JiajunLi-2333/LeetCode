#
# @lc app=leetcode id=2070 lang=python3
#
# [2070] Most Beautiful Item for Each Query
#

# @lc code=start
from math import inf
import bisect
class Solution:
    def maximumBeauty(self, items: list[list[int]], queries: list[int]) -> list[int]:
        #! Time Limit Exceeded
        # items.sort()
        # ans = [0] * len(queries)
        # for i in range(len(queries)):
        #     max_beauty = 0
        #     index = bisect.bisect_right(items, [queries[i], inf])
        #     if index == 0:
        #         ans[i] = 0
        #         continue
        #     for j in range(index):
        #         max_beauty = max(max_beauty, items[j][1])
        #     ans[i] = max_beauty
        # return ans
        #todo Quicker Solution
        items.sort()
        for i in range(1, len(items)):
            items[i][1] = max(items[i][1], items[i - 1][1])
        
        ans = []
        for i in range(len(queries)):
            index = bisect.bisect_right(items, [queries[i], inf])
            if index == 0:
                ans.append(0)
            else:
                ans.append(items[index - 1][1])
        return ans


        
# @lc code=end

