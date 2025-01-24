#
# @lc app=leetcode id=1208 lang=python3
#
# [1208] Get Equal Substrings Within Budget
#

# @lc code=start
class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        ans = 0
        cur_cost = 0
        left = 0
        for i in range(len(s)):
            cur_cost += abs(ord(s[i]) - ord(t[i]))

            while cur_cost > maxCost:
                cur_cost -= abs(ord(s[left]) - ord(t[left]))
                left += 1
            ans = max(ans, i - left + 1)
        return ans

# @lc code=end

