#
# @lc app=leetcode id=2516 lang=python3
#
# [2516] Take K of Each Character From Left and Right
#

# @lc code=start
from collections import Counter
from math import inf
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        #todo 1st subproblem: how do I know that my subarray is valid?
        # num_a, num_b, num_c = 0 ,0 ,0
        # ans, left  = float('inf') , 0
        # for i in range(len(s)):
        #     if s[i] == 'a':
        #         num_a += 1
        #     elif s[i] == 'b':
        #         num_b += 1
        #     else:
        #         num_c += 1
        # if min(num_a, num_b, num_c) < k:
        #     return -1 
        # for i in range(len(s)):
        #     if s[i] == 'a':
        #         num_a -= 1
        #     elif s[i] == 'b':
        #         num_b -= 1
        #     else: 
        #         num_c -= 1
        #     while min(num_a, num_b, num_c) < k:
        #         if s[left] == 'a':
        #             num_a += 1
        #         elif s[left] == 'b':
        #             num_b += 1
        #         else:
        #             num_c += 1
        #         left += 1
        #     ans = min(ans, len(s) - (i - left + 1))
        # return ans



        # solve by sliding window
        # 1. in the substring, all three characters should appear at least k times
        hashmap = Counter()
        for c in s:
            hashmap[c] += 1

        # identify three edge cases
        if min(hashmap.values()) < k:
            return -1
        if k == 0:
            return 0
        if len(hashmap) < 3:
            return -1
        
        
        ans, left = inf, 0

        for i, c in enumerate(s):
            hashmap[c] -= 1 
            while  hashmap[c] < k:
                hashmap[s[left]] += 1 
                left += 1 
            window_length = i - left + 1
            ans = min(ans, len(s) - window_length)
        return ans
# @lc code=end

