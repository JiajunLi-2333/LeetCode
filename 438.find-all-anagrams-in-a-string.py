#
# @lc app=leetcode id=438 lang=python3
#
# [438] Find All Anagrams in a String
#
# @lc code=start
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:

        # window_size = len(p)
        # hashmap = Counter()
        # result = []
        # #! This stores the letters and their frequency in the hashmap
        # for i in range(window_size):
        #     hashmap[p[i]] += 1      
        # for i in range(len(s)):
        #     if s[i] in hashmap:
        #         hashmap[s[i]] -= 1
        #     if i < window_size - 1:
        #         continue
        #     count = 0
        #     for value in hashmap.values():
        #         if value == 0:
        #             count += 1
        #     if count == len(hashmap):
        #         result.append(i - window_size + 1)
            
        #     if s[i - window_size + 1] in hashmap:
        #         hashmap[s[i - window_size + 1]] += 1
        # return result

            


        

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

        #! like question 567 we can use hashmap to solve the problem
        # hashmap = Counter()
        # ans = []
        # for c in p:
        #     hashmap[c] += 1
        # for i in range(len(s)):
        #     if s[i] in hashmap:
        #         hashmap[s[i]] -= 1
        #     if i < len(p) - 1:
        #         continue
        #     if all(value == 0 for value in hashmap.values()):
        #         ans.append(i - len(p) + 1)
        #     if s[i - len(p) + 1] in hashmap:
        #         hashmap[s[i - len(p) + 1]] += 1
        # return ans

        #! we can also use a different data structure like a list to solve th problem
        char_list = [0] * 26
        ans = []
        mask = ord('a')
        for c in p:
            char_list[ord(c) - mask] += 1

        for i in range(len(s)):
            if s[i] in p:
                char_list[ord(s[i]) - mask] -= 1
            if i < len(p) - 1: 
                continue
            if all(value == 0 for value in char_list):
                ans.append(i - len(p) + 1)
            if s[i - len(p) + 1] in p:
                char_list[ord(s[i - len(p) + 1]) - mask] += 1
        return ans
            
            #exis the window
            

# @lc code=end

