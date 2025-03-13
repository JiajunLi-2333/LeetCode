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
        # #? 枚举 A = array[i], 维护A 左边的最小值和最大值 这样就实现了两数不在同一个数组的条件
        # ans = 0
        # min_ele, max_ele = inf, -inf
        # for element in arrays:
        #     ans = max(ans, element[-1] - min_ele, max_ele - element[0])
        #     min_ele = min(min_ele, element[0])
        #     max_ele = max(max_ele, element[-1])
        # return ans

        #Re-Write version
        # Each arrray in arrays is sorted in non-decreasing order
        # Important Constraint: -104 <= arrays[i][j] <= 104
        # Each element must from different array

        #Goal is to find the maximum distance between two selected elements

        #Strategy: Iterate the right and maintain the left min and max

        #1. To ensure maximum distance, we always use the maximum element minus the minimum element 
        #2. To ensure that two element are from different arrays, we need to maintain the min and max to the left of the current array

        #Time Complexity: O(n)
        #Space Complexity: O(1)

        #Update the min and max value to the left of the current array
        mx, mi = -inf, inf
        #Update the maximum distance
        ans = 0
        for array in arrays:
            ans = max(ans, array[-1] - mi, mx - array[0])
            mx = max(mx, array[-1])
            mi = min(mi, array[0])
        return ans



# @lc code=end

