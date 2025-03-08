#
# @lc app=leetcode id=2953 lang=python3
#
# [2953] Count Complete Substrings
#

# @lc code=start
from collections import Counter
class Solution:
    def countCompleteSubstrings(self, word: str, k: int) -> int:
        def check(sub: str) -> int:
            ans = 0
            #There could be at most 26 different characters
            for m in range(1,27):
                if k * m > len(sub):
                    break
                cnt = Counter()
                for i, c in enumerate(sub):
                    cnt[c] += 1
                    left = i - k*m + 1

                    if left >= 0:
                        ans += 1 if all(c == k for c in cnt.values()) else 0 
                        cnt[sub[left]] -= 1
                        if cnt[sub[left]] == 0:
                            del cnt[sub[left]]
            return ans
                

        i = 0
        n = len(word)
        res = 0
        while i < n:
            begin = i
            i += 1
            while i < n and abs(ord(word[i]) - ord(word[i -1])) <= 2:
                i += 1
            res += check(word[begin:i])
        return res
            
# @lc code=end

