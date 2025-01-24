#
# @lc app=leetcode id=1493 lang=python3
#
# [1493] Longest Subarray of 1's After Deleting One Element
#

# @lc code=start

class Solution:
    def longestSubarray(self, nums: list[int]) -> int:
        count = 0
        left = 0
        ans = 0
        if len(nums) == sum(nums):
            return len(nums) - 1
        for i in range(len(nums)):
            if nums[i] == 0:
                count += 1
            while count == 2:
                if nums[left] == 0:
                    count -= 1
                left += 1
            ans = max(ans, i - left + 1 - count)
        return ans

        
# @lc code=end

