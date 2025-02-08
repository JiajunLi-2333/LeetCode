#
# @lc app=leetcode id=2260 lang=python3
#
# [2260] Minimum Consecutive Cards to Pick Up
#

# @lc code=start
from math import inf
from collections import Counter
class Solution:
    def minimumCardPickup(self, cards: list[int]) -> int:
        # ans = inf
        # hashmap = Counter()
        # for i, card in enumerate(cards):
        #     if card in hashmap: 
        #         ans = min(ans, i - hashmap[card] + 1)
        #     hashmap[card] = i
        # return ans if ans != inf else -1  

        #todo Sliding window solution
        #!Still very slow
        ans = inf
        left = 0
        hashmap = Counter()
        for i in range(len(cards)):
            hashmap[cards[i]] += 1
            while hashmap[cards[i]] > 1:
                ans = min(ans, i - left + 1)
                hashmap[cards[left]] -= 1
                left += 1
        return ans if ans != inf else -1    

# @lc code=end

