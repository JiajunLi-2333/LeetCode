#
# @lc app=leetcode id=713 lang=python3
#
# [713] Subarray Product Less Than K
#

# @lc code=start
class Solution:
    def numSubarrayProductLessThanK(self, nums: list[int], k: int) -> int:
        left, product, ans = 0, 1, 0
        if k <= 1: 
            return 0
        for i in range(len(nums)):
            product *= nums[i]
            while product >= k:
                product //= nums[left]
                left += 1
            ans += i - left + 1
        return ans 

  
        
# @lc code=end

