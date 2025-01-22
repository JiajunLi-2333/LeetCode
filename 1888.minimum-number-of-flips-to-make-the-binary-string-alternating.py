#
# @lc app=leetcode id=1888 lang=python3
#
# [1888] Minimum Number of Flips to Make the Binary String Alternating
#
#! a fucking hard and tricky problem
# @lc code=start
class Solution:
    def minFlips(self, s: str) -> int:
        ans, n = len(s), len(s)
        s += s
        #! Generate the two possible strings
        #? valid1: 01010101...
        #? valid2: 10101010...
        valid1 = ""
        valid2 = ""
        for i in range(2* n):
            if i % 2 == 0:
                valid1 += "0"
                valid2 += "1"
            else:
                valid1 += "1"
                valid2 += "0"
        #now we go through the for loop
        #How do I maintain the window?
        diff1, diff2 = 0, 0
        for i in range(2 * n):
            #Enter the window
            if s[i] != valid1[i]:
                diff1 += 1
            if s[i] != valid2[i]:
                diff2 += 1
            if i < n - 1:
                continue
            #This will be the first valid window of size n and we update the min Type2 flips
            ans = min(ans, min(diff1, diff2))
            #Now we Exit the window
            if s[i - n + 1] != valid1[i - n + 1]:
                diff1 -= 1
            elif s[i - n + 1] != valid2[i - n + 1]:
                diff2 -= 1
        return ans      
# @lc code=end

