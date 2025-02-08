#
# @lc app=leetcode id=219 lang=python3
#
# [219] Contains Duplicate II
#

# @lc code=start
from collections import Counter
class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        hashmap = Counter()
        ans = 0
        for i, num in enumerate(nums):
            if num in hashmap and i - hashmap[num] <= k:
                return True
            hashmap[num] = i
        return False     
# @lc code=end

