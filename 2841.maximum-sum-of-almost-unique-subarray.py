#
# @lc app=leetcode id=2841 lang=python3
#
# [2841] Maximum Sum of Almost Unique Subarray
#

# @lc code=start
from collections import Counter
class Solution:
    def maxSum(self, nums: list[int], m: int, k: int) -> int:
        sum = 0
        sum_list = []
        counter_dict = Counter()
        for i,c in enumerate(nums):
            sum += c 
            counter_dict[c] += 1
            if i <  k-1:
                continue
            if len(counter_dict) < m:
                sum -= nums[i - k +1]
                counter_dict[nums[i - k +1]] -= 1
                if counter_dict[nums[i - k +1]] == 0:
                    del counter_dict[nums[i - k +1]]
                continue
            sum_list.append(sum)
            #Exit the window
            sum -= nums[i - k +1]
            counter_dict[nums[i - k +1]] -= 1
            if counter_dict[nums[i - k +1]] == 0:
                del counter_dict[nums[i - k +1]]
        return max(sum_list) if sum_list else 0
    
#! I actually made it right, cannot believe it
# @lc code=end

