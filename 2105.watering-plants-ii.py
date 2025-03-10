#
# @lc app=leetcode id=2105 lang=python3
#
# [2105] Watering Plants II
#

# @lc code=start
from typing import List
class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:

        #max(plants[i]) <= capacityA, capacityB <= 109
        left, right = 0, len(plants) - 1
        cnt = 0
        Alice, Bob = capacityA, capacityB
        while left < right:
            if Alice < plants[left]:
                Alice = capacityA
                cnt += 1
            if Bob < plants[right]:
                Bob = capacityB
                cnt += 1
            Alice  -= plants[left]
            Bob -= plants[right]
            left += 1
            right -= 1
        
        if left == right:
            if (Alice == Bob and Alice < plants[left]) or (Bob > Alice and Bob < plants[left]) or (Alice > Bob and Alice < plants[left]):
                cnt += 1
        return cnt

        
# @lc code=end

