#
# @lc app=leetcode id=3185 lang=python3
#
# [3185] Count Pairs That Form a Complete Day II
#

# @lc code=start
from collections import Counter
class Solution:
    def countCompleteDayPairs(self, hours: list[int]) -> int:
        hashmap = Counter()
        ans, SIGMA = 0, 24
        for hour in hours:
            remainder = hour  % SIGMA
            ans += hashmap[(SIGMA - remainder) % SIGMA]
            hashmap[remainder] += 1
        return ans     
# @lc code=end

