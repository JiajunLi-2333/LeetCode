#
# @lc app=leetcode id=1818 lang=python3
#
# [1818] Minimum Absolute Sum Difference
#

# @lc code=start
from typing import List
from math import inf
import bisect
class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        diffsum, solodiff = 0, []
        minimum = inf
        n = len(nums1)
        for i in range(n):
            diff = abs(nums1[i] - nums2[i])
            diffsum += diff
            solodiff.append(diff)
        nums1.sort()
        for num, diff in zip(nums2, solodiff):
            index = bisect.bisect_left(nums1, num)
            if index >0:
                minimum = min(minimum, diffsum - diff + abs(nums1[index-1] - num))
            if index < n:
                minimum = min(minimum, diffsum - diff + abs(nums1[index] - num))
        return minimum % (10**9 + 7)

# @lc code=end

