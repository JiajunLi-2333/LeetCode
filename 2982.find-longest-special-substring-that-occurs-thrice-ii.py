#
# @lc app=leetcode id=2982 lang=python3
#
# [2982] Find Longest Special Substring That Occurs Thrice II
#

# @lc code=start
from collections import defaultdict
class Solution:
    def maximumLength(self, s: str) -> int:
        def check(x: int) -> bool:
            cnt = defaultdict(int)
            i = 0
            while i < n:
                j = i + 1
                while j < n and s[j] == s[i]:
                    j += 1
                
                cnt[s[i]] += max(0, j - i - x + 1)
                i = j
            return any(v >= 3 for v in cnt.values())
        n = len(s)

        
        left, right = 0, len(s)
        

        while left + 1  < right:
            mid = (left + right) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        if left == 0:
            return -1
        return left


            
        
# @lc code=end

