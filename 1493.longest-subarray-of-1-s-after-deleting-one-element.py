#
# @lc app=leetcode id=1493 lang=python3
#
# [1493] Longest Subarray of 1's After Deleting One Element
#

# @lc code=start

class Solution:
    def longestSubarray(self, nums: list[int]) -> int:
        # count = 0
        # left = 0
        # ans = 0
        # if len(nums) == sum(nums):
        #     return len(nums) - 1
        # for i in range(len(nums)):
        #     if nums[i] == 0:
        #         count += 1
        #     while count == 2:
        #         if nums[left] == 0:
        #             count -= 1
        #         left += 1
        #     ans = max(ans, i - left + 1 - count)
        # return ans

        #todo Let us work on the brutal force to deepen the understanding of using sliding window
        Zero_index = []
        cur_arr = []
        ans = 0
        if len(nums) == sum(nums):
            return len(nums) - 1
        for i in range(len(nums)):
            if nums[i] == 0:
                Zero_index.append(i)
        for i in range(len(Zero_index)):
            cur_arr = nums[:Zero_index[i]] + nums[Zero_index[i] + 1:]
            one_count = 0
            left = 0
            for j in range(len(cur_arr)):
                if cur_arr[j] == 0:
                    left = j  +1
                one_count = max(one_count, j - left + 1)
            ans = max(ans, one_count)
        return ans

        
# @lc code=end

