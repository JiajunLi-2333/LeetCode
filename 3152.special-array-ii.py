#
# @lc app=leetcode id=3152 lang=python3
#
# [3152] Special Array II
#
# @lc code=start
class Solution:
    def isArraySpecial(self, nums: list[int], queries: list[list[int]]) -> list[bool]:
        ans = []
        prefix = [0] * (len(nums) + 1)
        for i in range(0, len(nums)-1):
            if (nums[i] + nums[i + 1]) % 2 == 1:
                prefix[i + 1] = prefix[i] + 1
            else:
                prefix[i + 1] = prefix[i]
        for query in queries:
            if prefix[query[1]] - prefix[query[0]] < query[1] - query[0]:
                ans.append(False)
            else:
                ans.append(True)
        return ans
# @lc code=end

