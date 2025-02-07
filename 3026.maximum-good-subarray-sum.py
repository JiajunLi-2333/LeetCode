#
# @lc app=leetcode id=3026 lang=python3
#
# [3026] Maximum Good Subarray Sum
#

# @lc code=start
from collections import defaultdict
from math import inf  
class Solution:
    def maximumSubarraySum(self, nums: list[int], k: int) -> int:
        ans = -inf
        min_s = defaultdict(lambda: inf)
        s = 0
        for x in nums:
            ans = max(ans, s + x - min(min_s[x - k], min_s[x + k]))
            min_s[x] = min(min_s[x], s)
            s += x
        return ans if ans > -inf else 0

        
# @lc code=end

