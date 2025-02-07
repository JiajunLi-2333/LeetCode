#
# @lc app=leetcode id=525 lang=python3
#
# [525] Contiguous Array
#

# @lc code=start
from collections import Counter
class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        count = 0
        hashmap = Counter({0:-1})
        ans = 0
        for i in range(len(nums)):
            if nums[i]:
                count += 1 
            else:
                count -= 1
            if count in hashmap:
                ans = max(ans, i - hashmap[count])
            else:
                hashmap[count] = i
        return ans   

        
# @lc code=end

