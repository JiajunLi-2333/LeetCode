#
# @lc app=leetcode id=1552 lang=python3
#
# [1552] Magnetic Force Between Two Balls
#

# @lc code=start
from typing import List
class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        #Maximizing the minimum
        position.sort()

        def check(minforce: int) -> int:
            cnt = 1
            i = j = 0
            n = len(position)
            while i < n:
                if position[i] - position[j] >= minforce:
                    cnt += 1
                    j = i
                i += 1
            return cnt
        
        left, right = 1, position[-1] - position[0] + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid) >= m:
                left =mid
            else:
                right = mid
        return left
# @lc code=end

