#
# @lc app=leetcode id=2216 lang=python3
#
# [2216] Minimum Deletions to Make Array Beautiful
#

# @lc code=start
from typing import List
class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        #Use stack to simulate the deletion process
        #Stack is the beautiful nums array after deletion process

        #todo the key is to solve the index difference between the original array and the stack array

        count = 0
        stack = []
        for i in range(len(nums)):
            if (i - count) % 2 == 0:
                stack.append(nums[i])
            else:
                if stack and stack[-1] == nums[i]:
                    count += 1
                else:
                    stack.append(nums[i])
        if len(stack) % 2  == 1:
            count += 1
        return count


        # ans = 0
        # i, n, start = 1, len(nums), nums[0]  # 先把第一个元素放进去
        # odd = True  # 栈大小是否为奇数
        # while i < n:
        #     if odd:  # 此时不能与栈顶的值相同
        #         if nums[i] == start:
        #             ans += 1
        #         else:
        #             odd = 0
        #     else:
        #         odd = 1
        #         start = nums[i]  # 更新栈顶的元素值
        #     i += 1
        # return ans + (n - ans) % 2
 
# @lc code=end

