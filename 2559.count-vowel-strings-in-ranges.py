#
# @lc app=leetcode id=2559 lang=python3
#
# [2559] Count Vowel Strings in Ranges
#

# @lc code=start
class Solution:
    def vowelStrings(self, words: list[str], queries: list[list[int]]) -> list[int]:
        vowels = "aeiou"
        prefix = [0] * (len(words) + 1)
        ans = []
        for i, c in enumerate(words):
            if c[0] in vowels and c[-1] in vowels:
                prefix[i + 1] = prefix[i] + 1
            else:
                prefix[i + 1] = prefix[i]
        for query in queries:
            ans.append(prefix[query[1] + 1] - prefix[query[0]])
        return ans
                
        
# @lc code=end

