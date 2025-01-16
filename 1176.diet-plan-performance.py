#
# @lc app=leetcode id=1176 lang=python3
#
# [1176] Diet Plan Performance
#

# @lc code=start
class Solution:
    def dietPlanPerformance(self, calories: list[int], k: int, lower: int, upper: int) -> int:
        #todo This is just a slicing window problem
        sum = 0
        points = 0
        for i, c in enumerate(calories):
            sum += c
            if i < k - 1:
                continue
            if sum < lower:
                points -= 1
            elif sum > upper:
                points += 1
            sum -= calories[i - k + 1]
        return points
# @lc code=end

