#
# @lc app=leetcode id=950 lang=python3
#
# [950] Reveal Cards In Increasing Order
#

# @lc code=start
from typing import List
class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        queue = []
        # Sort the deck in decreasing order
        # to simulate the process of revealing cards
        deck.sort(reverse=True)
        for d in deck:
            if not queue:
                queue.append(d)
            else:
                queue.insert(0, queue.pop())
                queue.insert(0, d)
        return queue
        
# @lc code=end

