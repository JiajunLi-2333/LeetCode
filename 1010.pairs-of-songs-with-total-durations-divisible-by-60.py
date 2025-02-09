#
# @lc app=leetcode id=1010 lang=python3
#
# [1010] Pairs of Songs With Total Durations Divisible by 60
#

# @lc code=start
from collections import Counter
class Solution:
    def numPairsDivisibleBy60(self, time: list[int]) -> int:
        hashmap = Counter()
        ans = 0
        SIGMA = 60
        for t in time: 
            reminder = t % SIGMA
            ans += hashmap[ (SIGMA - reminder) % SIGMA]
            hashmap[reminder] += 1
        return ans

        
        
# @lc code=end

