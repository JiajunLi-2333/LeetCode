#
# @lc app=leetcode id=2909 lang=python3
#
# [2909] Minimum Sum of Mountain Triplets II
#

# @lc code=start
from typing import List
from math import inf
class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        n = len(nums)
        after = [0] * n
        after[-1] = nums[-1]
        for i in range(n-2, 1, -1):
            after[i] = min(after[i + 1], nums[i])
        
        pre = nums[0]
        ans = inf
        for i in range(1, n-1):
            if pre< nums[i] > after[i + 1]:
                ans = min(ans, nums[i] + pre + after[i + 1])
            pre = min(pre, nums[i])
        return ans if ans < inf else -1



# @lc code=end

