#
# @lc app=leetcode id=2962 lang=python3
#
# [2962] Count Subarrays Where Max Element Appears at Least K Times
#

# @lc code=start
class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        max_num = max(nums) 
        left, ans = 0, 0
        for i in range(len(nums)):
            if nums[i] == max_num:
                k -= 1
            while k == 0:
                if nums[left] == max_num:
                    k += 1
                left += 1
            ans += left
        return ans



          
        
# @lc code=end

