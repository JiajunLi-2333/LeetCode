#
# @lc app=leetcode id=1838 lang=python3
#
# [1838] Frequency of the Most Frequent Element
#

# @lc code=start
class Solution:
    def maxFrequency(self, nums: list[int], k: int) -> int:
        #! the elements in the subarray does not need to be consecutive in the original array
        # nums.sort()  
        # left = 0
        # window_sum = 0
        # ans = 1
        # for right in range(len(nums)):
        #     window_sum += nums[right]
        #     while nums[right] * (right - left + 1) - window_sum > k:
        #         window_sum -= nums[left]
        #         left += 1 
        #     # Update answer (window size)
        #     ans = max(ans, right - left + 1)
        
        # return ans


        #! by sliding window
        # nums.sort()
        # window_sum, left, ans= 0, 0, 0
        # for i in range(len(nums)):
        #     window_sum += nums[i]
        #     if window_sum +k < nums[i] * (i - left + 1):
        #         window_sum -= nums[left]
        #         left += 1
        #     ans = max(ans, i - left + 1)
        # return ans

        #! by binary search?
        #todo doable but not easy to come up with and the time complexity is O(nlogn)
        nums.sort()
        prefix = [0] * (len(nums) + 1)
        n = len(nums)
        #First find the prefix sum for easir sum later
        for i, num in enumerate(nums):
            prefix[i + 1] = prefix[i] + num
        
        def check(length: int) -> bool:
            left = 0
            for i in range(left, n - length + 1):
                right = i + length - 1 
                if nums[right] * length - (prefix[right + 1] - prefix[i]) <= k:
                    return True
            return False
        
        l, r  = 0, n + 1
        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid):
                l = mid
            else:
                r = mid
        return r -1

            

# @lc code=end

