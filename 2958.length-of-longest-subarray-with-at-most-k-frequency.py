#
# @lc app=leetcode id=2958 lang=python3
#
# [2958] Length of Longest Subarray With at Most K Frequency
#

# @lc code=start
from collections import Counter
class Solution:
    def maxSubarrayLengsth(self, nums: list[int], k: int) -> int:
        hashmap = Counter()
        left, ans = 0, 0
        for i in range(len(nums)):
            hashmap[nums[i]] += 1
            while hashmap[nums[i]] > k:
                hashmap[nums[left]] -= 1
                left += 1
            ans = max(ans, i - left  + 1)
        return ans
# @lc code=end

