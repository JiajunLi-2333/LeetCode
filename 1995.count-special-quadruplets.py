#
# @lc app=leetcode id=1995 lang=python3
#
# [1995] Count Special Quadruplets
#

# @lc code=start
from collections import Counter
class Solution:
    def countQuadruplets(self, nums: list[int]) -> int:
        # Below is the brutal force solution
        # n = len(nums)
        # count = 0
        # for i in range(n):
        #     for j in range(i+1, n):
        #         for k in range(j+1, n):
        #             for l in range(k+1, n):
        #                 if nums[i] + nums[j] + nums[k] == nums[l]:
        #                     count += 1
        # return count


        #todo Below is the optimized solution
        #From the question, we can know that num[a] + num[b] = num[d] - num[c]
        #So we can use a dict to store the value of num[d] - num[c]
        # ans = 0
        # n = len(nums)
        # hashmap = Counter()
        # # Move c from right to left (starting at n-2 so c+1 is valid).
        # for c in range(n - 2, 0, -1):
        #     for a in range(c):
        #         ans += hashmap[nums[a] + nums[c]]
        #     for d in range(c + 1, n):
        #         hashmap[nums[d] - nums[c]] += 1
        
        # return ans


        #nums[a] + nums[b] = nums[d] - nums[c]
        
        
# @lc code=end

