#
# @lc app=leetcode id=2342 lang=python3
#
# [2342] Max Sum of a Pair With Equal Sum of Digits
#

# @lc code=start
from collections import Counter
class Solution:
    def maximumSum(self, nums: list[int]) -> int:
        hashmap = Counter()
        ans = 0
        for num in nums:
            sum_digits = sum(map(int, str(num)))
            #Update the answer
            if sum_digits in hashmap:
                ans = max(ans, hashmap[sum_digits] + num)
            #Update the hashmap
            hashmap[sum_digits] = max(hashmap[sum_digits], num)
        return -1 if ans == 0 else ans
# @lc code=end

