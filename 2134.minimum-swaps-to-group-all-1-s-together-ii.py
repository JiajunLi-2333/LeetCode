#
# @lc app=leetcode id=2134 lang=python3
#
# [2134] Minimum Swaps to Group All 1's Together II
#

# @lc code=start
class Solution:
    def minSwaps(self, nums: list[int]) -> int:
        # #! This is the brutal force solution to append more items to the original nums list and we use the sliding window to find the minimum swaps This method works but it is not optimized and takes O(n + k) time complexity
        # num_ones = sum(nums)
        # n = len(nums)
        # ans = len(nums)
        # count = 0
        # #Define the edge cases
        # if num_ones == 0 or num_ones == 1:
        #     return 0
        # #update the nums list to handle the circular array
        # for i in range(num_ones -1):
        #     nums.append(nums[i])
        # for i in range(len(nums)):
        #     if nums[i] == 1:
        #         count += 1
        #     if i < num_ones -1: 
        #         continue
        #     ans = min(ans, num_ones - count)
        #     if nums[i - num_ones + 1] == 1:
        #         count -= 1
        # return ans 

        #! This is the optimized solution to find the minimum swaps which achieves the O(n) time complexity


        #? This is the failed optimized solution to handle the circular array by modular calculations because the use of subarray needs too much time complexity

        # ans = len(nums)
        # num_ones = sum(nums)
        # n = ans
        # #Define the edge cases
        # if num_ones == 0 or num_ones == 1:
        #     return 0
        # for i in range(n):
        #     #This defines the ending index of the window
        #     end_index = (i + num_ones -1) % n + 1  
        #     if end_index > i:
        #         window_array = nums[i:end_index]
        #         ans = min(ans, num_ones - sum(window_array))
        #     else:
        #         window_array = nums[i:] + nums[:end_index]
        #         ans = min(ans, num_ones - sum(window_array))
        # return ans

        #todo Best solution here

        #! This is the optimized solution to find the minimum swaps which achieves the O(n) time complexity and This method fully uses the binary attributes of the array
        num_ones = sum(nums)
        ans = len(nums)
        if num_ones == 0 or num_ones == 1:
            return 0
        right = 0
        #window one's count
        one_count = nums[0]
        for left in range(len(nums)):

            if left != 0:
                one_count -= nums[left - 1]
            while right - left + 1 < num_ones:
                right += 1
                one_count += nums[right % len(nums)]
            ans = min(ans, num_ones - one_count)
        return ans
                
# @lc code=end

