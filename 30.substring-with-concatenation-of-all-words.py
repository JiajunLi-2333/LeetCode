#
# @lc app=leetcode id=30 lang=python3
#
# [30] Substring with Concatenation of All Words
#

# @lc code=start]
from collections import Counter , defaultdict
class Solution:
    def findSubstring(self, s: str, words: list[str]) -> list[int]:
        # words_count = len(words)
        # words_len = len(words[0])
        # window_size = words_count * words_len
        # left = 0
        # ans = []
        # if len(s) < window_size:
        #     return []
        # words_dict = Counter()
        # for word in words:
        #     words_dict[word] += 1
        
        # for i in range(window_size - 1, len(s)):
        #     hashmap = Counter()
        #     for j in range(words_count):
        #         cur_word = s[left + j * words_len: left + (j + 1) * words_len]
        #         if cur_word not in words_dict:
        #             break
        #         hashmap[cur_word] += 1
        #     if hashmap == words_dict:
        #         ans.append(left)
        #     left += 1
        # return ans
        wordsCount = Counter(words)
        n, wordLen = len(s), len(words[0])
        totalLen = wordLen * len(words)
        ans = []

        # we need to traverse s worldLen times
        for i in range(wordLen):
            curCount = defaultdict(int)

            # tarverse s with diff beginning index
            for j in range(i, n-wordLen+1, wordLen):

                # hashing a worldLen len string
                if s[j:j+wordLen] in wordsCount:
                    curCount[s[j:j+wordLen]] += 1

                # subtract a worldLen len string if the string in words
                if j >= totalLen and s[j-totalLen: j-totalLen+wordLen] in wordsCount:
                    curCount[s[j-totalLen: j-totalLen+wordLen]] -= 1

                if curCount == wordsCount:
                    ans.append(j-totalLen+wordLen)
        return ans
# @lc code=end

