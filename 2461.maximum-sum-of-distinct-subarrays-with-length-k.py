#
# @lc app=leetcode id=2461 lang=python3
#
# [2461] Maximum Sum of Distinct Subarrays With Length K
#

# @lc code=start
from collections import Counter
class Solution:
    def maximumSubarraySum(self, nums: list[int], k: int) -> int:
        #! This is the hashmap with fixed slicing window solution
        #! you can see here that we have duplicate code for exiting the slicing window
        #! And it is very slow and cumnbersome
        # sum = 0
        # sum_list = []
        # hashmap = Counter()
        # for i, c in enumerate(nums):
        #     sum += c
        #     hashmap[c] += 1
        #     if i < k - 1:
        #         continue
        #     if len(hashmap) != k:
        #         sum -= nums[i - k + 1]
        #         hashmap[nums[i - k + 1]] -= 1
        #         if hashmap[nums[i - k + 1]] == 0:
        #             del hashmap[nums[i - k + 1]]
        #         continue      
        #     sum_list.append(sum)
        #     #Exit the window
        #     sum -= nums[i - k + 1]
        #     hashmap[nums[i - k + 1]] -= 1
        #     if hashmap[nums[i - k + 1]] == 0:
        #         del hashmap[nums[i - k + 1]]
        # return max(sum_list) if sum_list else 0

        #! This approach also uses slicing window with hashmap
        #! But the hashmap now stores the index of the element
        #! And now we dynamically adjust the window size to avoid redundant checks
        sum = 0
        numLastIndex = {}
        max_sum = 0
        begin, end = 0, 0
        while end < len(nums):
            #Enter the window
            curr_num = nums[end]
            last_occr = numLastIndex.get(curr_num, -1)
            #todo Update the status
            #Check if the number is already in the hashmap
            #update the position of the begin index
            while begin <= last_occr or end - begin + 1 > k:
                sum -= nums[begin]
                begin += 1
            #This is when the proper set is found
            numLastIndex[curr_num] = end
            sum += nums[end]
            if end - begin + 1 == k:
                #Update the maximum sum
                max_sum = max(sum, max_sum)
            end += 1
        return max_sum 

#! Hashmap can take on either the count of the element 
#! Or hashamp takes on the index of the element      
# @lc code=end

