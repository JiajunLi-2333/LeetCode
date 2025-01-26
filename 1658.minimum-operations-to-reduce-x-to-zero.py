#
# @lc app=leetcode id=1658 lang=python3
#
# [1658] Minimum Operations to Reduce X to Zero
#

# @lc code=start
class Solution:
    def minOperations(self, nums: list[int], x: int) -> int:
        total = sum(nums)
        left = 0
        ans = float('inf')
        for i in range(len(nums)):
            total -= nums[i]
            while total < x and left <= i:
                total += nums[left]
                left += 1
            #! only when we have a valid subarray, we can update the answer
            if total == x:
                ans = min(ans, len(nums) - (i - left + 1))
        return ans if ans != float('inf') else -1  
# @lc code=end

