#
# @lc app=leetcode id=567 lang=python3
#
# [567] Permutation in String
#

# @lc code=start
from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        #todo Problem decompose and understand:                                   The order has to be that s2 contains a permutation of s1 not the other way around                                                                                      how do you check that if s2 contains a permutation of s1 or not

        #! The solution is sliding window and hash map on s1 to record the unique characters and their count in s1


        # #! I missed the fact that 
        # ans = False
        # hashmap = Counter()
        # left = 0
        # #! Edge case
        # if len(s1) > len(s2):
        #     return ans 
        
        # #Generate the unique characters in s1
        # for i in range(len(s1)):
        #     hashmap[s1[i]] += 1


        # #! Sliding window       
        # for i in range(len(s2)):
            
        #     if s2[i] in hashmap:
        #         hashmap[s2[i]] -= 1
            
        #     if i < len(s1) - 1:
        #         continue

        #     count = 0
        #     for value in hashmap.values():
        #         if value != 0:
        #             count += 1
        #     if count == 0:
        #         ans = True
        #         break

        #     #! Shrink the window
        #     if s2[left] in hashmap:
        #         hashmap[s2[left]] += 1
        #     left += 1
        # return ans

        hashmap = Counter()
        for s in s1:
            hashmap[s] += 1

        left = 0
        ans = False

        for right in range(len(s2)):
            if s2[right] in hashmap:
                hashmap[s2[right]] -= 1
            
            if right < len(s1) - 1:
                continue

            if all(value == 0 for value in hashmap.values()):
                ans = True
                break
            else:
                if s2[left] in hashmap:
                    hashmap[s2[left]] += 1
                left += 1
        return ans
 # @lc code=end

