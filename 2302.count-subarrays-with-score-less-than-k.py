#
# @lc app=leetcode id=2302 lang=python3
#
# [2302] Count Subarrays With Score Less Than K
#

# @lc code=start
class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        ans, left, sum = 0,0,0
        for i,c  in enumerate(nums):
            sum += c
            while sum * (i - left  + 1) >= k:
                sum -= nums[left]
                left += 1
            ans += i - left + 1
        return ans
        
# @lc code=end

