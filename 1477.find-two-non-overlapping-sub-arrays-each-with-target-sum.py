#
# @lc app=leetcode id=1477 lang=python3
#
# [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
#

# @lc code=start
from collections import Counter
class Solution:
    def minSumOfLengths(self, arr: list[int], target: int) -> int:
        hashmap = Counter({0:0})
        preSum = 0
        length_arr = list()

        for i in range(len(arr)):
            preSum += arr[i]
            hashmap[preSum] = i + 1
            if preSum - target in hashmap:
                length_arr.append(hashmap[preSum] - hashmap[preSum - target])
        length_arr.sort()
        return -1 if len(length_arr) < 2 else sum(length_arr[:2])

        
# @lc code=end  

