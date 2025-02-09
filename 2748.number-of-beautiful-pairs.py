#
# @lc app=leetcode id=2748 lang=python3
#
# [2748] Number of Beautiful Pairs
#

# @lc code=start
from math import gcd
class Solution:
    def countBeautifulPairs(self, nums: list[int]) -> int:
        # ans = 0
        # count = [0] * 10
        # for num in nums:
        #     for i, c in enumerate(count):
        #         if c and gcd(i, num % 10) == 1:
        #             ans += c
        #     while num >= 10:
        #         num //= 10
        #     count[num] += 1
        # return ans

        #todo we can store the coprime number in an array to reduce the time of gcd calculation

        #? Only God knows how disgusting this solution is
        ans = 0
        prime = [None, \
                (1,2,3,4,5,6,7,8,9), \
                (1,3,5,7,9), \
                (1,2,4,5,7,8), \
                (1,3,5,7,9), \
                (1,2,3,4,6,7,8,9), \
                (1,5,7),\
                (1,2,3,4,5,6,8,9),\
                (1,3,5,7,9),\
                (1,2,4,5,7,8)]
        count = [0] * 10
        for num in nums:
            for i in prime[num % 10]:
                ans += count[i]
            while num >= 10:
                num //= 10 
            count[num] += 1
        return ans
            
        
# @lc code=end

