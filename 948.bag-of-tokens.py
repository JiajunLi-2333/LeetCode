#
# @lc app=leetcode id=948 lang=python3
#
# [948] Bag of Tokens
#

# @lc code=start
from typing import List
class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:

        #! trade-off between power and score
        #If tokens[i] < power, gain 1 point and power - tokens[i]
        #If tokens[i] > power, lose 1 point and power + tokens[i]
        #Initial score = 0 -> have to reduce power to gain score

        #Goal: find the maximum score

        #Strategy:
        #Always try to trade the score for the more power if power is not enough 
        #If the power is enough, then trade the power for the score
        #If power is not enough and score is 0, then break the loop

        #Implementation:
        #1. Sort the tokens
        #2. Use two pointers to iterate the tokens
        #3. If power >= tokens[left], then trade the power for the score
        #4. If power < tokens[left] and score > 0, then trade the score for the power
        #5. If power < tokens[left] and score == 0, then break the loop
        #6. Always update the maximum answer
        tokens.sort()
        ans = 0
        score = 0
        left, right = 0, len(tokens) - 1
        while left <= right:
            if power >= tokens[left]:
                power -= tokens[left]
                score += 1
                left += 1
                ans = max(ans, score)
            elif score > 0 and power < tokens[left]:
                power += tokens[right]
                score -= 1
                right -= 1
            else:
                break
        return ans   
# @lc code=end

