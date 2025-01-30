#
# @lc app=leetcode id=3258 lang=python3
#
# [3258] Count Substrings That Satisfy K-Constraint I
#

# @lc code=start
class Solution:
    def countKConstraintSubstrings(self, s: str, k: int) -> int:
        #! Correct answer but could be faster
        # count = [0] * 2
        # left, ans = 0, 0
        # for i,c in enumerate(s):
        #     if c == '1':
        #         count[1] += 1
        #     else: 
        #         count[0] += 1
        #     while min(count) > k:
        #         if s[left] == '1':
        #             count[1] -= 1
        #         else:
        #             count[0] -= 1
        #         left += 1
        #     ans += i - left + 1
        # return ans
        


        #todo  Faster Solution
        sum, left, ans = 0, 0, 0
        for i,c in enumerate(s):
            sum += int(c)
            while (i -left  +1) - sum > k and sum > k:
                sum -= int(s[left])
                left += 1
            ans += i - left + 1
        return ans        
# @lc code=end

