#
# @lc app=leetcode id=1512 lang=python3
#
# [1512] Number of Good Pairs
#

# @lc code=start
from collections import defaultdict
class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        ans = 0
        hashmap = defaultdict(int)
        for num in nums:
            ans += hashmap[num]
            hashmap[num] += 1
        return ans        
# @lc code=end

