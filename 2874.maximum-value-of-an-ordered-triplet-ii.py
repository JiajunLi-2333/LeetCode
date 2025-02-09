#
# @lc app=leetcode id=2874 lang=python3
#
# [2874] Maximum Value of an Ordered Triplet II
#

# @lc code=start
class Solution:
    def maximumTripletValue(self, nums: list[int]) -> int:
        #When iterating k, the status of i and j will be updated at the same time.
        ans = max_diff = pre_max = 0
        for num in nums:
            ans = max(ans, num * max_diff)
            # These are the variables that need to be maintained on the left while iterate the right.
            max_diff = max(max_diff, pre_max - num)
            pre_max = max(pre_max, num)
        return 0 if ans < 0 else ans
# @lc code=end

