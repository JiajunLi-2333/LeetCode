#
# @lc app=leetcode id=1852 lang=python3
#
# [1852] Distinct Numbers in Each Subarray
#

# @lc code=start
from collections import Counter
class Solution:
    def distinctNumbers(self, nums: list[int], k: int) -> list[int]:
        ans = []
        hashmap = Counter()

        for i in range(len(nums)):
            hashmap[nums[i]] += 1
            if i < k -1:
                continue
            ans.append(len(hashmap))

            hashmap[nums[i - k + 1]] -= 1
            if hashmap[nums[i - k + 1]] == 0:
                del hashmap[nums[i - k + 1]]
        return ans

        #The set() funciton causes too much time complexity
        # ans = [] 
        # count = 0
        # curr_subarray = nums[:k]
        # count = len(set(curr_subarray))
        # ans.append(count)
        # for i in range(k, len(nums)):
        #     reserve = curr_subarray.pop(0)
        #     next = nums[i]
        #     if reserve not in curr_subarray:
        #         count -= 1
        #     if nums[i] not in curr_subarray:
        #         count += 1
        #     ans.append(count)
        #     curr_subarray.append(nums[i])
        # return ans
# @lc code=end

