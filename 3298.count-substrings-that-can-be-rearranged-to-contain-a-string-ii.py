#
# @lc app=leetcode id=3298 lang=python3
#
# [3298] Count Substrings That Can Be Rearranged to Contain a String II
#

# @lc code=start
from collections import Counter
class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        char = Counter()
        left, ans = 0, 0
        #This defines the prefix
        for c in word2:
            char[ord(c) - ord('a')] += 1
        
        for i in range(len(word1)):
            if (ord(word1[i]) - ord('a')) in char:
                char[ord(word1[i]) - ord('a')] -= 1
            while max(char.values()) == 0:
                if (ord(word1[left]) - ord('a')) in char:
                    char[ord(word1[left]) - ord('a')] += 1
                left += 1
            ans += left
        return ans
        
        
# @lc code=end

