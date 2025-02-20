#
# @lc app=leetcode id=1385 lang=python3
#
# [1385] Find the Distance Value Between Two Arrays
#

# @lc code=start
import bisect
class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        #todo use the binary search to find the distance value
        arr2.sort()
        ans = 0

        for element in arr1:
            lower_bound = element - d
            upper_bound = element + d

            if bisect.bisect_left(arr2, lower_bound) == bisect.bisect_right(arr2, upper_bound):
                ans += 1
        return ans

        
# @lc code=end

