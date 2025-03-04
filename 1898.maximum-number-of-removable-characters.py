#
# @lc app=leetcode id=1898 lang=python3
#
# [1898] Maximum Number of Removable Characters
#

# @lc code=start
from typing import List
class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        def check(k: int) -> bool:
            #! need to check if p is a subsequence of s after removing k elements from removable
            # remove k elements from the string
            temp = list(s)
            for i in range(k):
                temp[removable[i]] = ''
            s_removed = ''.join(temp)
            #check if p is a subsequence of s_removed
            i, j = 0, 0
            while i < len(s_removed) and j < len(p):
                if s_removed[i] == p[j]:
                    j += 1
                i += 1
            return j == len(p)
        left = 0
        right = len(removable) + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left        
# @lc code=end

