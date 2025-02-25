#
# @lc app=leetcode id=2815 lang=python3
#
# [2815] Max Pair Sum in an Array
#

# @lc code=start
from typing import List
from collections import defaultdict
class Solution:
    def maxSum(self, nums: List[int]) -> int:
        ans = 0
        hashmap = defaultdict(int)
        for num in nums:
            max_digit = max(str(num))
            if max_digit in hashmap:
                ans = max(ans, hashmap[max_digit] + num)
            hashmap[max_digit] = max(hashmap[max_digit], num)
        return ans if ans != 0 else -1
# @lc code=end

