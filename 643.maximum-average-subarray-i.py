 #
# @lc app=leetcode id=643 lang=python3
#
# [643] Maximum Average Subarray I
#

# @lc code=start
from math import inf
class Solution(object):
    def findMaxAverage(self, nums, k):
        # current_sum = 0
        # ave_array = list()

        # for i, c in enumerate(nums):
        #     current_sum += c
        #     if i < k -1 :
        #         continue
        #     current_ave = float(current_sum) / k
        #     ave_array.append(current_ave)
        #     current_sum -= nums[i - k + 1]
        
        # return max(ave_array)

        window_sum = 0
        ans = -inf
        for i , c in enumerate(nums):
            window_sum += c
            if i < k - 1:
                continue
            ave = window_sum / k
            ans = max(ans, ave)

            window_sum -= nums[i - k + 1]
        return ans 

        
# @lc code=end

