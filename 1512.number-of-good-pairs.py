#
# @lc app=leetcode id=1512 lang=python3
#
# [1512] Number of Good Pairs
#

# @lc code=start
from collections import Counter
class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        ans = 0
        hashmap = Counter()
        for num in nums:
            if num in hashmap:
                ans += hashmap[num]
            hashmap[num] += 1
        return ans        
# @lc code=end

