#
# @lc app=leetcode id=3404 lang=python3
#
# [3404] Count Special Subsequences
#

# @lc code=start
from typing import List
from collections import Counter
class Solution:
    def numberOfSubsequences(self, nums: List[int]) -> int:
        hashmap = Counter()
        n = len(nums)
        ans = 0
        for r in range(4, n - 2):
            q = nums[r - 2]
            for p in nums[: r - 3]:
                hashmap[p/q] += 1

            for s in nums[r + 2:]:
                ans += hashmap[s/nums[r]] 
        return ans        


        
# @lc code=end

