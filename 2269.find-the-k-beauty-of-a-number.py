#
# @lc app=leetcode id=2269 lang=python3
#
# [2269] Find the K-Beauty of a Number
#

# @lc code=start
class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        num_str = str(num)
        n = len(num_str)
        total = 0 
        for i in range(0, n - k  + 1 ):
            cur = num_str[i:i+k]
            if cur[0] == '0' and int(cur) == 0:
                continue
            if num  % int(cur) == 0:
                total += 1
        return total        
# @lc code=end

