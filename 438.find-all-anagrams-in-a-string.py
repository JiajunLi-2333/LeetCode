#
# @lc app=leetcode id=438 lang=python3
#
# [438] Find All Anagrams in a String
#
# @lc code=start
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:

        window_size = len(p)
        hashmap = Counter()
        result = []

        #! This stores the letters and their frequency in the hashmap
        for i in range(window_size):
            hashmap[p[i]] += 1
        
        for i in range(len(s)- window_size +  1):
            if s[i] in hashmap:
                end = 0
                count  = 0
                while end < window_size:
                    if s[i + end] in hashmap and hashmap[s[i + end]] > 0:
                        hashmap[s[i + end]] -= 1
                        count += 1
                    end += 1
                if count == len(hashmap):
                    result.append(i)

        return result

            


        

        # p_length = len(p)
        # s_length = len(s)

        # if p_length > s_length:
        #     return []

        # p_counter = [0] * 26
        # s_counter = [0] * 26

        # for i in range(p_length):
        #     p_counter[ord(p[i]) - ord('a')] += 1
        #     s_counter[ord(s[i]) - ord('a')] += 1

        # result = []
        # for i in range(s_length - p_length):
        #     if p_counter == s_counter:
        #         result.append(i)

        #     s_counter[ord(s[i]) - ord('a')] -= 1
        #     s_counter[ord(s[i + p_length]) - ord('a')] += 1

        # if p_counter == s_counter:
        #     result.append(s_length - p_length)

        # return result
# @lc code=end

