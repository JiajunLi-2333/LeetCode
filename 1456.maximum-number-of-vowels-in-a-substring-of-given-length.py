#
# @lc app=leetcode id=1456 lang=python
#
# [1456] Maximum Number of Vowels in a Substring of Given Length
#

# @lc code=start
class Solution(object):
    def maxVowels(self, s, k):
        # max_vowel = 0
        # vowel = 0

        # #The i in the iterative process is the right pointer
        # for i, c in enumerate(s):
        #     #Element enter the slicing window
        #     if c in 'aeiou':
        #         vowel += 1
        #     if i < k - 1:
        #         continue

        #     #Update the maximum
        #     max_vowel = max(max_vowel, vowel)

        #     #Element leave the window
        #     #Here is the left pointer
        #     if s[i - k + 1] in 'aeiou':
        #         vowel -= 1
        # return max_vowel
        cnt = 0
        max_cnt = -1 

        for i, c in enumerate(s):
            if c in 'aeiou':
                cnt += 1
            if i < k -1:
                continue
            max_cnt = max(max_cnt, cnt)

            if s[i - k + 1] in 'aeiou':
                cnt -= 1
        return max_cnt        
# @lc code=end

