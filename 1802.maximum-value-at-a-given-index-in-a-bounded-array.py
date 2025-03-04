#
# @lc app=leetcode id=1802 lang=python3
#
# [1802] Maximum Value at a Given Index in a Bounded Array
#

# @lc code=start
class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        #Log: Time limit exceeded on the check function
        # def check(maxNum:int) -> bool:
            # leftsum = rightsum = 0
            # for i in range(index):
            #     num_add = maxNum - i - 1
            #     if num_add < 1:
            #         leftsum += 1
            #     else:
            #         leftsum += num_add
            # for i in range(n -1 - index):
            #     num_add = maxNum - i - 1
            #     if num_add < 1:
            #         rightsum += 1
            #     else:
            #         rightsum += num_add
            # if leftsum + rightsum + maxNum <= maxSum:
            #     return True
            # return False


        # left = 0
        # right = maxSum + 1
        # while left + 1 < right:
        #     mid = (left + right) // 2
        #     if check(mid):
        #         left = mid
        #     else:
        #         right = mid
        # return left


        # Helper function to calculate the sum on one side of the index.
        # length is the number of positions on that side.
        def calc(x: int, length: int) -> int:
                if x > length:
                    # When the sequence can decrease fully without hitting 1.
                    return (x - length + x - 1) * length // 2
                else:
                    # When the sequence is too short and hits 1, fill extra positions with 1.
                    return (x - 1) * x // 2 + (length - (x - 1))
        
        # Binary search for the maximum valid x.
        left, right = 1, maxSum
        while left < right:
            mid = (left + right + 1) // 2
            # Calculate the sum on the left side and the right side.
            left_sum = calc(mid, index)
            right_sum = calc(mid, n - index - 1)
            total = left_sum + right_sum + mid  # include the candidate at the index
            
            if total <= maxSum:
                left = mid
            else:
                right = mid -1
        return left
# @lc code=end

