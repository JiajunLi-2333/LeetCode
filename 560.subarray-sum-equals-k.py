#
# @lc app=leetcode id=560 lang=python3
#
# [560] Subarray Sum Equals K
#

# @lc code=start
class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        count = 0
        sum = 0
        sum_dict = {0: 1}
        for num in nums:
            sum += num
            count += sum_dict.get(sum - k, 0)
            sum_dict[sum] = sum_dict.get(sum, 0) + 1
        return count
        
# @lc code=end

