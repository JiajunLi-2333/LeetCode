#
# @lc app=leetcode id=2960 lang=python3
#
# [2960] Count Tested Devices After Test Operations
#

# @lc code=start
from typing import List
class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        # diff = [0] * (len(batteryPercentages) + 1)
        # for i in range(len(batteryPercentages)):
        #     if batteryPercentages[i] > 0:
        #         diff[0] += 1
        #         for j in range (i + 1, len(batteryPercentages)):
        #             batteryPercentages[j] = max(0, batteryPercentages[j] - 1)
                
        # return sum(diff)

        # cnt = 0
        # for i in range(len(batteryPercentages)):
        #     if batteryPercentages[i] > 0:
        #         cnt += 1
        #         for j in range(i + 1, len(batteryPercentages)):
        #             batteryPercentages[j] = max(0, batteryPercentages[j] - 1)
        # return cnt

        dec = 0
        for x in batteryPercentages:
            if x > dec:
                dec += 1
        return dec
              
# @lc code=end

