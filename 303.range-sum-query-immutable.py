#
# @lc app=leetcode id=303 lang=python3
#
# [303] Range Sum Query - Immutable
#

# @lc code=start
class NumArray:
    def __init__(self, nums: list[int]):
        array = [0] * (len(nums) + 1)
        for i, c in enumerate(nums):
            array[i + 1] = array[i] + c
        self.array = array
    def sumRange(self, left: int, right: int) -> int:
        return self.array[right + 1] - self.array[left]
# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
# @lc code=end

