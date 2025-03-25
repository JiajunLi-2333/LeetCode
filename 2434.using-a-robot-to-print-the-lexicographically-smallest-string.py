#
# @lc app=leetcode id=2434 lang=python3
#
# [2434] Using a Robot to Print the Lexicographically Smallest String
#

# @lc code=start
from collections import Counter
from string import ascii_lowercase
class Solution:
    def robotWithString(self, s: str) -> str:


        #! how to ensure the lexicographically smallest string?
        #! when should the letter of t be added to paper?

        #! how to keep record of the smallest character of the rest of the string s?
        stack, ans = [], []
        #Record the count of each character
        cnt = Counter(s)
        #Record the smallest character of the rest of the string s
        min = 0

        for c in s:
            cnt[c] -= 1
            while min < 25 and cnt[ascii_lowercase[min]] == 0:
                min += 1  
            stack.append(c)
            while stack and stack[-1] <= ascii_lowercase[min]:
                ans.append(stack.pop())
        return ''.join(ans) 
        
# @lc code=end

