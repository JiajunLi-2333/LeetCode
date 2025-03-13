#
# @lc app=leetcode id=1930 lang=python3
#
# [1930] Unique Length-3 Palindromic Subsequences
#

# @lc code=start
class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        # Find number of subsequences in s
        # Subsequence must be length 3 and must be unique palindromes
        ans = set()
        after = [0] * 26
        pre = [0] * 26

        n = len(s)
        for i in range(1, n):
            after[ord(s[i]) - ord('a')] += 1
        
        for i in range(1, n-1):
            pre[ord(s[i-1])- ord('a')] += 1
            after[ord(s[i]) - ord('a')] -= 1

            for j in range(26 ):
                if pre[j] > 0 and after[j] > 0:
                    cur = chr(j + ord("a")) + s[i] + chr(j + ord("a"))
                    ans.add(cur )
        return len(ans)
# @lc code=end

