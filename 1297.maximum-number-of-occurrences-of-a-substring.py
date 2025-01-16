#
# @lc app=leetcode id=1297 lang=python3
#
# [1297] Maximum Number of Occurrences of a Substring
#

# @lc code=start
from collections import Counter
class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        #! So the maxSize is just a distraction????
        #! The minSize is the key to the solution 
        left = 0
        hashmap = Counter()
        for i in range(len(s)):
            #todo Enter the window
            if i < minSize -1:
                continue
            #todo Find the correct window size
            curr_str = s[left:i+1]

            #todo Check if the current window is valid
            if len(set(curr_str)) > maxLetters:
                left += 1
                continue
            #todo If the current window is valid, add it to the hashmap
            hashmap[curr_str] += 1
            left += 1
        return max(hashmap.values()) if hashmap else 0
# @lc code=end

