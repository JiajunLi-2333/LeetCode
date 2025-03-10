#
# @lc app=leetcode id=125 lang=python3
#
# [125] Valid Palindrome
#

# @lc code=start
class Solution:
    def isPalindrome(self, s: str) -> bool:

        # s_ = ''
        # for c in s:
        #     if "A" <= c <= "Z":
        #         s_ += c.lower()
        #     elif "a" <= c <= "z":
        #         s_ += c
        #     elif "0" <= c <= "9":
        #         s_ += c
        # s_reverse = ''
        # for i in range(len(s_) - 1, -1,-1):
        #     s_reverse += s_[i]
        # return s_ == s_reverse
        i, j = 0, len(s) - 1
        while i < j:
            if not s[i].isalnum():
                i += 1
            elif not s[j].isalnum():
                j -= 1
            elif s[i].lower() == s[j].lower():
                i += 1
                j -= 1
            else:
                return False
        return True

        
# @lc code=end

