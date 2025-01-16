#
# @lc app=leetcode id=1423 lang=python3
#
# [1423] Maximum Points You Can Obtain from Cards
#

# @lc code=start
class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        sum = 0
        ans = 0
        window_size = len(cardPoints) - k
        #First get the sum of all the elements
        for i in range(len(cardPoints)):
            sum += cardPoints[i]
        if k == len(cardPoints):
            return sum
        for i, c in enumerate(cardPoints):
            sum -= c
            if i < len(cardPoints) - k - 1:
                continue
            #Exit the window
            ans = max(ans, sum)
            sum += cardPoints[i - window_size + 1 ]
        return ans
    
#! Not really that hard, just need to figure the correct window size
# @lc code=end

