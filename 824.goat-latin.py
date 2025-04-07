#
# @lc app=leetcode id=824 lang=python3
#
# [824] Goat Latin
#

# @lc code=start
class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        vowels = set("aeiouAEIOU")
        words = sentence.split(" ")
        for i, word in enumerate(words):
            if word[0] in vowels:
                word = word +  "ma"
            else:
                word = word[1:] + word[0] + "ma"
            word = word +  "a" * (i + 1)
            words[i] = word
        return " ".join(words)
# @lc code=end

