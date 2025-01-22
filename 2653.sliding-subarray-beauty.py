#
# @lc app=leetcode id=2653 lang=python3
#
# [2653] Sliding Subarray Beauty
#

# @lc code=start]
class Solution:
    def getSubarrayBeauty(self, nums: list[int], k: int, x: int) -> list[int]:
        #! This is the brutal force

        #todo sub-problem:
        #todo 1. In the subarray, find the number of negative integers
        #todo 2. In the subarray, find the order of the numbers. where I need to fix it by iterating the subarray

        ans = []        
        #!check whether the element is negative or not
        freq = [0] * 50

        for i in range(len(nums)):
            #Enter the window
            if nums[i] < 0:
                freq[50 + nums[i]] += 1   
            if i < k - 1:
                continue

            #! Record the number of negative integers
            count = 0
            for j in range(50):
                count += freq[j]
                if count >=x:
                    ans.append(j - 50)
                    break
            if count < x:
                ans.append(0)
            
            #Exit the window
            if nums[i - k + 1] < 0:
                freq[50 + nums[i - k + 1]] -= 1
        return ans
# @lc code=end

