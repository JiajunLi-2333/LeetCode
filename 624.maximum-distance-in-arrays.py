#
# @lc app=leetcode id=624 lang=python3
#
# [624] Maximum Distance in Arrays
#

# @lc code=start
from math import inf
class Solution:
    def maxDistance(self, arrays: list[list[int]]) -> int:
        #todo Correct solution
        #? 枚举 A = array[i], 维护A 左边的最小值和最大值 这样就实现了两数不在同一个数组的条件
        ans = 0
        min_ele, max_ele = inf, -inf
        for element in arrays:
            ans = max(ans, element[-1] - min_ele, max_ele - element[0])
            min_ele = min(min_ele, element[0])
            max_ele = max(max_ele, element[-1])
        return ans
# @lc code=end

