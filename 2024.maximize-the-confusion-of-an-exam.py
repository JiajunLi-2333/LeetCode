#
# @lc app=leetcode id=2024 lang=python3
#
# [2024] Maximize the Confusion of an Exam
#

# @lc code=start
from collections import Counter
class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        #! Slding window solution that traverse the string twice, one is to change T to F and another is to change F to T
        # def helper(answerKey, k, letter):
        #     i = 0
        #     j = 0
        #     max_len = 0
        #     while j < len(answerKey):
        #         if answerKey[j] != letter:
        #             k -= 1
        #         while k < 0:
        #             if answerKey[i] != letter:
        #                 k += 1
        #             i += 1
        #         max_len = max(max_len, j - i + 1)
        #         j += 1
        #     return max_len
        # return max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'))


        #! Sliding window solution that traverse the string once
        #todo The logic is that we keep track of the number of T and F in the window and if the number of T or F exceeds the k, we move the left pointer to the right until the number of T or F is less than k
        maxf = i = 0
        count = Counter()
        for j in range(len(answerKey)):
            count[answerKey[j]] += 1
            maxf = max(maxf, count[answerKey[j]])
            if j - i + 1 > maxf + k:
                count[answerKey[i]] -= 1
                i += 1
        return len(answerKey) - i
# @lc code=end

