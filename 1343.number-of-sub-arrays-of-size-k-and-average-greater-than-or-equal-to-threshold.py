#
# @lc app=leetcode id=1343 lang=python3
#
# [1343] Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
#

# @lc code=start
class Solution:
    def numOfSubarrays(self, arr: list[int], k: int, threshold: int) -> int:
        #This is the optimal solution
        # sum = 0
        # total = 0
        # for i, c in enumerate(arr):
        #     sum += c
        #     if i < k - 1:
        #         continue
        #     current_ave = sum/k
        #     if current_ave >= threshold:
        #         total += 1
        #     sum -= arr[i - k + 1]
        # return total 
        # 
        # This is the brute force solution
        sum, left, total = 0,0,0
        for right in range(len(arr)):
            #Enter the window
            sum += arr[right]
            if right - left + 1 < k:
                continue
            #Check if the average is greater than or equal to threshold
            if sum/k >= threshold:
                total += 1
            #Exit the window
            sum -= arr[left]
            left += 1
        return total 
            

# @lc code=end