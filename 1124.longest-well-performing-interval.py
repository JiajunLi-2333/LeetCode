#
# @lc app=leetcode id=1124 lang=python3
#
# [1124] Longest Well-Performing Interval
#

# @lc code=start
class Solution:
    def longestWPI(self, hours: list[int]) -> int:
        ans, score = 0, 0
        #Store the index of the first occurence of a score
        first_occurence = {}
        for i, hour in enumerate(hours):
            if hour > 8:
                score += 1
            else:
                score -= 1
            
            if score > 0: 
                ans = i + 1
            first_occurence.setdefault(score, i)
            if score - 1 in first_occurence:
                ans = max(ans, i - first_occurence[score - 1])
        return ans
        
# @lc code=end

