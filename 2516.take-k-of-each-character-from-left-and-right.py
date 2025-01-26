#
# @lc app=leetcode id=2516 lang=python3
#
# [2516] Take K of Each Character From Left and Right
#

# @lc code=start
class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        #todo 1st subproblem: how do I know that my subarray is valid?
        num_a, num_b, num_c = 0 ,0 ,0
        ans, left  = float('inf') , 0
        for i in range(len(s)):
            if s[i] == 'a':
                num_a += 1
            elif s[i] == 'b':
                num_b += 1
            else:
                num_c += 1
        if min(num_a, num_b, num_c) < k:
            return -1 
        for i in range(len(s)):
            if s[i] == 'a':
                num_a -= 1
            elif s[i] == 'b':
                num_b -= 1
            else: 
                num_c -= 1
            while min(num_a, num_b, num_c) < k:
                if s[left] == 'a':
                    num_a += 1
                elif s[left] == 'b':
                    num_b += 1
                else:
                    num_c += 1
                left += 1
            ans = min(ans, len(s) - (i - left + 1))
        return ans
# @lc code=end

