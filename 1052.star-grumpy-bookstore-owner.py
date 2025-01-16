#
# @lc app=leetcode id=1052 lang=python3
#
# [1052] Grumpy Bookstore Owner
#

# @lc code=start
class Solution:
    def maxSatisfied(self, customers: list[int], grumpy: list[int], minutes: int) -> int:
        Override = 0
        Override_list = []
        sum_satisfied = 0
        #Find the initial satisfied customers
        for i in range(len(grumpy)):
            if grumpy[i] == 0:
                sum_satisfied += customers[i]
        for i, c in enumerate(grumpy):
            #Enter the window
            Override += customers[i]
            if c == 0:
                sum_satisfied -= customers[i]
            if i < minutes - 1:
                continue 
            #Update all the status
            Override_list.append(Override + sum_satisfied)
            #Exit the window
            Override -= customers[i - minutes + 1]
            if grumpy[i - minutes + 1] == 0:
                sum_satisfied += customers[i - minutes + 1]
        return max(Override_list) if Override_list else 0
# @lc code=end

#! Took me some time but I got a very solid result and understanding
#! of slicing window
#! This is probably the best outcome I can get from this problem
