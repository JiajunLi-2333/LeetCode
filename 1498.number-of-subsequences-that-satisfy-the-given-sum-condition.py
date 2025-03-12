#
# @lc app=leetcode id=1498 lang=python3
#
# [1498] Number of Subsequences That Satisfy the Given Sum Condition
#

# @lc code=start
from typing import List
class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        n = len(nums)
        MOD = 10 ** 9 + 7
        nums.sort()
        cnt = 0
        j, k = 0, n-1
        while j <= k:
            if nums[j] + nums[k] > target:
                k-=1
            else:
                cnt += (pow(2, k - j, MOD))
                j +=1
        return cnt % MOD


# @lc code=end

