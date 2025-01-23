#
# @lc app=leetcode id=2156 lang=python3
#
# [2156] Find Substring With Given Hash Value
#

# @lc code=start
class Solution:
    def subStrHash(self, s: str, power: int, modulo: int, k: int, hashValue: int) -> str:
        #todo Better solution: Add pre computation to remove the inner loop of calculating the hash value
        def val(c):
            return ord(c) - ord('a') + 1
            
        res = n = len(s)
        pk = pow(power,k,modulo)
        cur = 0

        for i in range(n - 1, -1, -1):
            cur = (cur * power + val(s[i])) % modulo
            if i + k < n:
                cur = (cur - val(s[i + k]) * pk) % modulo
            if cur == hashValue:
                res = i
        return s[res: res + k]
        #!The brutal force exceeds the time limit
        # #This is to find the val(s[i])
        # mask = ord('a') -1 
        
        # for i in range(len(s)):
        #     if i < k -1:
        #         continue
        #     #Now we  have the first valid window
        #     cur_str = s[i - k + 1:i + 1]
        #     #Calculate the hash value of the current window 
        #     sum = 0
        #     for j in range(k):
        #         value = (ord(cur_str[j]) - mask) * power**(j)
        #         sum += value
        #     hash = sum % modulo
        #     if hash == hashValue:
        #         return cur_str
# @lc code=end

