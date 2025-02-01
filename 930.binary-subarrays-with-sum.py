#
# @lc app=leetcode id=930 lang=python3
#
# [930] Binary Subarrays With Sum
#

# @lc code=start
from collections import Counter
class Solution:
    def numSubarraysWithSum(self, nums: list[int], goal: int) -> int:

        #! Time limit exceeded
        # preSum = [0] * (len(nums) + 1)
        # ans = 0
        # for i in range(len(nums)):
        #     preSum[i + 1] = preSum[i] + nums[i]
        # for i in range(len(preSum)):
        #     if (preSum[i] + goal) in preSum:
        #         ans += preSum[(i + 1):].count(preSum[i] + goal)
        # return ans

        #todo: Sliding window
        # def atMost(goal):
        #     if goal < 0:
        #         return 0
        #     ans = 0
        #     left = 0
        #     for right in range(len(nums)):
        #         goal -= nums[right]
        #         while goal < 0:
        #             goal += nums[left]
        #             left += 1
        #         ans += right - left + 1
        #     return ans
        # return atMost(goal) - atMost(goal - 1)

        #use prefix sum
        c = Counter({0: 1})
        preSum = ans = 0
        for num in nums:
            preSum += num
            ans += c[preSum - goal]
            c[preSum] += 1
        return ans


         
# @lc code=end

