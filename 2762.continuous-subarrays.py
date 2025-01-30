#
# @lc app=leetcode id=2762 lang=python3
#
# [2762] Continuous Subarrays
#

# @lc code=start
from collections import deque
from sortedcontainers import SortedList
class Solution:
    def continuousSubarrays(self, nums: list[int]) -> int:
        # max_min = SortedList()
        # left, ans = 0 ,0
        # for i in range(len(nums)):
        #     max_min.add(nums[i])
        #     while max_min[-1] - max_min[0] > 2:
        #         max_min.remove(nums[left])
        #         left += 1

        #     ans += i - left + 1
        # return ans

        #todo This is a faster solution with queue and deque so that we do not need to sort the list to add on the time complexity
        l, res = 0, 0
        minD, maxD = deque(), deque()
        
        for r in range(len(nums)):
            while minD and nums[minD[-1]] >= nums[r]: minD.pop()
            while maxD and nums[maxD[-1]] <= nums[r]: maxD.pop()
            minD.append(r)
            maxD.append(r)
            
            while nums[maxD[0]] - nums[minD[0]] > 2:
                l += 1
                if minD[0] < l: minD.popleft()
                if maxD[0] < l: maxD.popleft()
            
            res += r - l + 1
        
        return res
        
# @lc code=end

