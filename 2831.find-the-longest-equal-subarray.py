#
# @lc app=leetcode id=2831 lang=python3
#
# [2831] Find the Longest Equal Subarray
#

# @lc code=start
from collections import Counter
class Solution:
    def longestEqualSubarray(self, nums: list[int], k: int) -> int:
        maxf = i = 0
        count = Counter()
        for j in range(len(nums)):
            count[nums[j]] += 1
            maxf = max(maxf, count[nums[j]])
            if j - i + 1 - maxf > k:
                count[nums[i]] -= 1
                i += 1
        return maxf
        
# @lc code=end

