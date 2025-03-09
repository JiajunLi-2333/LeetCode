#
# @lc app=leetcode id=2831 lang=python3
#
# [2831] Find the Longest Equal Subarray
#

# @lc code=start
from collections import Counter
from collections import defaultdict
class Solution:
    def longestEqualSubarray(self, nums: list[int], k: int) -> int:
        # maxf = i = 0
        # count = Counter()
        # for j in range(len(nums)):
        #     count[nums[j]] += 1
        #     maxf = max(maxf, count[nums[j]])
        #     if j - i + 1 - maxf > k:
        #         count[nums[i]] -= 1
        #         i += 1
        # return maxf





        #all then elements in the subarray are equal
        #we can delete at most k elements from the subarray

        #find the longest subarray

        #todo  for each unique number, I need to find the index it first appearsa and the index in last appears
        #todo  for each unique number, I need to know how many times it appears in the subarray

        hashmap = defaultdict(list)
        for i, c in enumerate(nums):
            hashmap[c].append(i)
        
        ans = 0
        for interval in hashmap.values():
            if len(interval) <= ans:
                continue
            left = 0
            for i in range(len(interval)):
                while interval[i] - interval[left] - (i - left) > k:
                    left += 1
                ans = max(ans, i - left + 1)
        return ans

                
                
# @lc code=end

