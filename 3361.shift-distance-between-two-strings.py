#
# @lc app=leetcode id=3361 lang=python3
#
# [3361] Shift Distance Between Two Strings
#

# @lc code=start
class Solution:
    def shiftDistance(self, s: str, t: str, nextCost: list[int], previousCost: list[int]) -> int:
        alphabet = 26
        ans, ord_a = 0, ord('a')
        preSum_next = [0] * (alphabet * 2 + + 1)
        preSum_previous = [0] * (alphabet * 2 + 1)

        for i in range(alphabet * 2):
            preSum_next[i + 1] = preSum_next[i] + nextCost[i % alphabet]

            preSum_previous[i + 1] = preSum_previous[i] + previousCost[i % alphabet]

        for i in range(len(s)):
            current = ord(s[i]) - ord_a
            target = ord(t[i]) - ord_a
            if target > current:
                ans += min(preSum_next[target] - preSum_next[current], preSum_previous[current + alphabet + 1] - preSum_previous[target + 1])

            else:
                ans += min(preSum_next[target + alphabet] - preSum_next[current], preSum_previous[current + 1] - preSum_previous[target + 1])
        return ans
# @lc code=end

