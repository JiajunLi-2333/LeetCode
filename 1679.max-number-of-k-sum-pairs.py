#
# @lc app=leetcode id=1679 lang=python3
#
# [1679] Max Number of K-Sum Pairs
#

# @lc code=start
from collections import Counter
class Solution:
    def maxOperations(self, nums: list[int], k: int) -> int:
        # ans = 0
        # hasmap = Counter()
        # for num in nums:
        #     if k - num in hasmap and hasmap[k - num] > 0:
        #         ans += 1
        #         hasmap[k - num] -= 1
        #         hasmap[num] -= 1
        #     hasmap[num] += 1
        # return ans

        #todo If I use Counter
        # ans = 0
        # cnt = Counter()
        # for x in nums:
        #     if cnt[k - x]:
        #         cnt[k - x] -= 1
        #         ans += 1
        #     else:
        #         cnt[x] += 1
        # return ans

        #todo If I use two pointers
        nums.sort()
        n = len(nums)
        left = 0
        right = n - 1
        ans = 0 
        while left < right:
            if nums[left] + nums[right] == k:
                ans += 1
                left += 1
                right -= 1
            elif nums[left] + nums[right] < k:
                left += 1
            else:
                right -= 1
        return ans
# @lc code=end

