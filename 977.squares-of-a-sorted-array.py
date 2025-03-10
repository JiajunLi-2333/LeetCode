#
# @lc app=leetcode id=977 lang=python3
#
# [977] Squares of a Sorted Array
#

# @lc code=start
from typing import List
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:

        #The time complexity of this solution is O(nlogn) because of the sorting step.
        #The space complexity is O(1).
        # res = []
        # for num in nums:
        #     res.append(num * num)
        # return sorted(res)

        left, right = 0, len(nums) - 1
        ans = [0] * len(nums)
        n = len(nums)
        for i in range(n -1, -1, -1):
            x, y = nums[left], nums[right]
            if -x < y:
                ans[i] = y * y
                right -= 1
            else:
                ans[i] = x * x
                left += 1
        return ans


        
# @lc code=end

