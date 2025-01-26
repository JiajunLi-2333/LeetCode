#
# @lc app=leetcode id=1838 lang=python3
#
# [1838] Frequency of the Most Frequent Element
#

# @lc code=start
class Solution:
    def maxFrequency(self, nums: list[int], k: int) -> int:
        #! the elements in the subarray does not need to be consecutive in the original array
        nums.sort()  
        left = 0
        window_sum = 0
        ans = 1
        for right in range(len(nums)):
            window_sum += nums[right]
            while nums[right] * (right - left + 1) - window_sum > k:
                window_sum -= nums[left]
                left += 1 
            # Update answer (window size)
            ans = max(ans, right - left + 1)
        
        return ans
# @lc code=end

