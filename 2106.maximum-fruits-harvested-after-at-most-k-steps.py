#
# @lc app=leetcode id=2106 lang=python3
#
# [2106] Maximum Fruits Harvested After at Most K Steps
#

# @lc code=start
from itertools import accumulate
from bisect import bisect_left

class Solution:
    def maxTotalFruits(self, fruits: list[list[int]], startPos: int, k: int) -> int:



        left = bisect_left(fruits, [startPos - k])  # 向左最远能到 fruits[left][0]
        right = bisect_left(fruits, [startPos + 1])  # startPos 右边最近水果（因为下面求的是左闭右开区间）
        ans = s = sum(c for _, c in fruits[left:right])  # 从 fruits[left][0] 到 startPos 的水果数
        while right < len(fruits) and fruits[right][0] <= startPos + k:
            s += fruits[right][1]  # 枚举最右位置为 fruits[right][0]
            while fruits[right][0] * 2 - fruits[left][0] - startPos > k and \
                  fruits[right][0] - fruits[left][0] * 2 + startPos > k:
                s -= fruits[left][1]  # fruits[left][0] 无法到达
                left += 1
            ans = max(ans, s)  # 更新答案最大值
            right += 1  # 继续枚举下一个最右位置
        return ans
        #! This brutal force solution takes too much time to run but logicall correct
        # ans = 0
        # max_pos = max(post for post, _ in fruits)
        # Fruits = [0] *(2* max_pos + 1)
        # for pos, value in fruits:
        #     Fruits[pos] = value
        # for i in range(k) :
        #     left_end = startPos - i
        #     right_end = startPos + i 
        #     j = left = left_end
        #     total = 0
        #     while j <= right_end:
        #         total += Fruits[j]
        #         if j - left + 1 < startPos - left_end + 1:
        #             j += 1
        #             continue
        #         ans = max(ans, total)
        #         total -= Fruits[left]
        #         left += 1
        #         j += 1

        # ans = max(ans, sum(Fruits[startPos - k : startPos + 1]), sum(Fruits[startPos: startPos + k + 1]))
        # return ans   
        #
        #! This is the optimized solution
            # Fruits = [0]*(2*200000 + 1)
            # for pos, val in fruits:
            #     Fruits[pos] = val

            # from itertools import accumulate
            # # Make prefix sums with an initial 0:
            # presum = [0] + list(accumulate(Fruits))
            # # Now, sum of [L..R] = presum[R+1] - presum[L]

            # ans = 0

            # # Go left first
            # for i in range(k+1):
            #     leftEnd = startPos - i
            #     length = k - 2*i
            #     if leftEnd < 0:
            #         continue  # can't go left beyond index 0
            #     if length >= 0:
            #         rightEnd = startPos + length
            #         # sum of [leftEnd..rightEnd]
            #         # watch for array boundaries if rightEnd too large
            #         if rightEnd >= len(Fruits):
            #             rightEnd = len(Fruits) - 1
            #         total = presum[rightEnd + 1] - presum[leftEnd]
            #     else:
            #         # no 'right' steps, only left
            #         # sum of [leftEnd..startPos]
            #         if startPos >= len(Fruits):
            #             continue
            #         total = presum[startPos + 1] - presum[leftEnd]

            #     ans = max(ans, total)

            # # Go right first
            # for i in range(k+1):
            #     rightEnd = startPos + i
            #     length = k - 2*i
            #     if rightEnd >= len(Fruits):
            #         break
            #     if length >= 0:
            #         leftEnd = startPos - length
            #         if leftEnd < 0:
            #             leftEnd = 0
            #         total = presum[rightEnd + 1] - presum[leftEnd]
            #     else:
            #         # no 'left' steps, only right
            #         if startPos + 1 >= len(presum):
            #             continue
            #         total = presum[rightEnd + 1] - presum[startPos]
            #     ans = max(ans, total)

            # return ans
            

# @lc code=end

