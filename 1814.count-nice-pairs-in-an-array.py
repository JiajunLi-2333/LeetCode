#
# @lc app=leetcode id=1814 lang=python3
#
# [1814] Count Nice Pairs in an Array
#

# @lc code=start
from collections import Counter
from math import comb
class Solution:
    def countNicePairs(self, nums: list[int]) -> int:
        # def rev(num):
        #     y = 0
        #     while num:
        #         y = y * 10 + num % 10
        #         num //= 10
        #     return y
        # ans = 0
        # hashmap = Counter()
        # for num in nums:
        #     if num - rev(num) in hashmap:
        #         ans += hashmap[num - rev(num)]
        #     hashmap[num - rev(num)] += 1
        # return ans % (10**9 + 7)
                # nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) can be rewritten as
        # nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        
        rev_count = Counter([n - int(str(n)[::-1]) for n in nums]) # freq of each nums[i] - rev(nums[i])
        
        # for each group of same nums[i] - rev(nums[i]), find total pair combinations
        # return all pairs modulo 10^9 + 7
        return sum(comb(count, 2) for count in rev_count.values()) % (10**9 + 7)
        
# @lc code=end

