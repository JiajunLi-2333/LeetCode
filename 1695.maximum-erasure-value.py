#
# @lc app=leetcode id=1695 lang=python3
#
# [1695] Maximum Erasure Value
#

# @lc code=start
from collections import Counter
class Solution:
    def maximumUniqueSubarray(self, nums: list[int]) -> int:
        # hashmap = Counter()
        # ans = 0
        # cur_sum = 0
        # left = 0
        # for i in range(len(nums)):
        #     hashmap[nums[i]] += 1
        #     cur_sum += nums[i]
        #     while len(hashmap) < i - left +1:
        #         hashmap[nums[left]] -= 1
        #         cur_sum -= nums[left]
        #         if hashmap[nums[left]] == 0: del hashmap[nums[left]]
        #         left += 1
        #     ans = max(ans, cur_sum)
        # return ans

        #! This is a better way of solving this problem by checking if the current number is in the set 

        i =0
        max_sum= 0
        sum = 0
        seen = set()

        for j in range(len(nums)):
            while nums[j] in seen:
                seen.remove(nums[i])
                sum -= nums[i]
                i+=1
            
            seen.add(nums[j])
            sum += nums[j]

            max_sum = max(max_sum, sum)
        return max_sum


        
        
# @lc code=end

