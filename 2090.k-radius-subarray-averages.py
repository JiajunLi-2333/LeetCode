#
# @lc app=leetcode id=2090 lang=python3
#
# [2090] K Radius Subarray Averages
#

# @lc code=start
class Solution:
    def getAverages(self, nums: list[int], k: int) -> list[int]:
        #! This brutal force is not slicing window 
        #! Because the use of sum() recalculates the sum of the subarray all the time
        # ave = list()
        # sum_radius = 0
        # for i in range(len(nums)):
        #     if  i >= k and i + k <= len(nums) - 1:
        #         sum_radius = sum(nums[i - k : i + k + 1])
        #         ave.append(sum_radius // (2 * k + 1))
        #     else:
        #         ave.append(-1)
        # return ave

        # #? Slicing window method
        # ave = list()
        # sum = 0
        if k == 0:
            return nums
        if 2*k + 1 > len(nums):
            return [-1] * len(nums)
        
        # for i, c in enumerate(nums):
        #     #Enter the window
        #     sum += c
        #     if i < 2*k:
        #         continue
        #     ave.append(sum // (2 * k + 1))
        #     #Exit the window
        #     sum -= nums[i - 2*k]
        # for j in range(k):
        #     ave.insert(0,-1)
        #     ave.append(-1) 
        # return ave

        #todo method revised to reduce one for loop
        ave = [-1] * len(nums)
        sum = 0
        window_size = 2 * k + 1
        for i in range(len(nums)):
            sum += nums[i]
            if i < window_size - 1:
                continue
            ave[i - k] = sum // window_size
            sum -= nums[i - window_size + 1]
        return ave

        #! In this question, we have to notice that the window size is not just k but 2k + 1 and for the result, only the middle elements of arr needs to be changed, all the others are just -1. Read the question carefully and examine the result to see if there is any pattern that could benefit the solution.
# @lc code=end

