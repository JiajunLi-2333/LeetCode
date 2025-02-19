#
# @lc app=leetcode id=2300 lang=python3
#
# [2300] Successful Pairs of Spells and Potions
#

# @lc code=start
class Solution:
    def successfulPairs(self, spells: list[int], potions: list[int], success: int) -> list[int]:
        def binary_search(nums: list[int], target: int) -> int:
            left, right =  0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left
        potions.sort()
        ans = [0] * len(spells)
        for i in range(len(spells)):
            if success % spells[i] == 0:
                ans[i] = len(potions) - binary_search(potions, (success // spells[i])) 
            else:
                ans[i] = len(potions) - binary_search(potions, (success // spells[i]) + 1) 
        return ans
# @lc code=end

