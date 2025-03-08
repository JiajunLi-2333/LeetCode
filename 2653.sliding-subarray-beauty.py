#
# @lc app=leetcode id=2653 lang=python3
#
# [2653] Sliding Subarray Beauty
#

# @lc code=start]
from sortedcontainers import SortedList
class Solution:
    def getSubarrayBeauty(self, nums: list[int], k: int, x: int) -> list[int]:
        #! This is the brutal force

        #todo sub-problem:
        #todo 1. In the subarray, find the number of negative integers

        #todo 2. In the subarray, find the order of the numbers. where I need to fix it by iterating the subarray

        #! The key takeaway is to see that the ans will always be either 0 or negative numbers I have to improve on exploring how the problem conditions would affect the output

        # ans = []        
        # #!check whether the element is negative or not
        # freq = [0] * 50
        # for i in range(len(nums)):
        #     #Enter the window
        #     if nums[i] < 0:
        #         freq[50 + nums[i]] += 1   
        #     if i < k - 1:
        #         continue
        #     #! Record the number of negative integers
        #     count = 0
        #     for j in range(50):
        #         count += freq[j]
        #         if count >=x:
        #             ans.append(j - 50)
        #             break
        #     if count < x:
        #         ans.append(0) 
        #     #Exit the window
        #     if nums[i - k + 1] < 0:
        #         freq[50 + nums[i - k + 1]] -= 1
        # return ans

        #! This is the most efficient soluton 91.53% faster than all users, using the sorted list method
        # neg_list = SortedList()
        # ans = []
        # neg_count = 0
        # for i in range(len(nums)):
        #     if nums[i] < 0:
        #         neg_list.add(nums[i])
        #         neg_count += 1
        #     if i < k - 1:
        #         continue
        #     if neg_count >= x:
        #         ans.append(neg_list[x - 1])
        #     else: 
        #         ans.append(0)
        #     #Exit the window
        #     if nums[i - k + 1] < 0:
        #         neg_list.remove(nums[i - k + 1])
        #         neg_count -= 1
        # return ans

        ans = []
        freq = [0] * 50
        for i in range(len(nums)):
            if nums[i] < 0:
                freq[50 + nums[i]] += 1
            if i < k -1:
                continue

            cnt = 0
            for j in range(50):
                cnt += freq[j]
                if cnt >= x:
                    ans.append(j - 50)
                    break
            if cnt < x:
                ans.append(0)
            if nums[i - k + 1] < 0:
                freq[50 + nums[i - k + 1]] -= 1
        return ans
# @lc code=end

