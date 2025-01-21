#
# @lc app=leetcode id=1151 lang=python3
#
# [1151] Minimum Swaps to Group All 1's Together
#

# @lc code=start
class Solution:
    def minSwaps(self, data: list[int]) -> int:

        #! This is step finds the number of ones in the data, which equals to the size of the window
        num_ones = sum(data)
        count = 0
        ans = len(data)
        #! This defines the edge case
        if num_ones == 1 or num_ones == 0:
            return 0
        
        for i in range(len(data)):
            #Enter the window
            if data[i] == 1:
                count += 1
            if i < num_ones -1:
                continue
            ans = min(ans, num_ones - count)
            #Exit the window
            if data[i - num_ones + 1] == 1:
                count -= 1
        return ans

        
# @lc code=end

