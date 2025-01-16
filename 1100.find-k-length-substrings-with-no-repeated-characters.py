#
# @lc app=leetcode id=1100 lang=python3
#
# [1100] Find K-Length Substrings With No Repeated Characters
#

# @lc code=start
from collections import Counter
class Solution:
    def numKLenSubstrNoRepeats(self, s: str, k: int) -> int:
        #! This is the normal slicing window solution
        #! O(n) time complexity and the window will go over some repeated substrings that wastes time and space
        # total = 0
        # left, right = 0 ,0
        # window = list()
        # if len(s) < k:
        #     return 0
        # while right < len(s):
        #     window.append(s[right])
        #     if right - left + 1 < k:
        #         right +=1
        #         continue
        #     if len(set(window)) < k:
        #         window.remove(s[left])
        #         left += 1
        #         right += 1
        #         continue
        #     total += 1
        #     window.remove(s[left])
        #     left += 1
        #     right += 1
        # return total  

    #todo This is the optimized solution with dynamically changing window size and O(n) time complexity and O(1) space complexity
    
        #! Initialize the left and right pointers
        right, left, total = 0, 0, 0 
        #! Initialize the hashmap to store the last_occurence of each of the characters
        hashmap = Counter()
        if len(s) < k:
            return 0
        while right < len(s):
            last_occurence = hashmap.get(s[right], -1)
            hashmap[s[right]] = right
            #This is when the character is in the map and at the same time it is repeated in the current window

            #! I call this the jumping window technique to shrink the window size dynamically
            while left <= last_occurence: 
                left += 1
            if right - left + 1 > k:
                left += 1 
            if right - left  + 1 == k:
                total += 1
                left += 1
            right += 1
        return total 
            


            

# @lc code=end

