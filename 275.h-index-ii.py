#
# @lc app=leetcode id=275 lang=python3
#
# [275] H-Index II
#

# @lc code=start
from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:



        #todo treating left and right as the index pointer to the answer but not the answer itself

        # left and left - 1 always meet the condition
        # right + 1 always not meet the conditon regardless of the value of right
        # left = 0
        # right = len(citations)
        # while left < right:
        #     mid = (left + right + 1) // 2ø
        #     if citations[-mid] >= mid:
        #         left = mid
        #     else:
        #         right = mid - 1
        # return right # or return left


        # left - 1 always meet the condition regardless of value of left
        # right + 1 always not meet the condition regardless of value of right
        # left = 1
        # right = len(citations)
        # while left <= right:
        #     mid = (left + right) // 2
        #     if citations[-mid] >= mid:
        #         left = mid + 1
        #     else:
        #         right = mid - 1
        # return right
    
        #left and left - 1 always meet the condition
        #right and right + 1 always not meet the condition
        left = 0
        right = len(citations) + 1
        while left + 1 < right:
            mid = (left + right) // 2
            if citations[-mid] >= mid:
                left = mid
            else:
                right = mid
        return left #or return right - 1

        #left -1 always meet the condition regardless of the value of left
        #right and right + 1 always not meet the condition

        # left = 1
        # right = len(citations) + 1
        # while left < right:
        #     mid = (left + right) // 2
        #     if citations[-mid] >= mid:
        #         left = mid + 1
        #     else:
        #         right = mid
        # return left - 1 # or return right - 1

        #? The method below of treating left and right as index but not value directily has the drawback of exceeding the memory limit
        # h_index = list(range(len(citations) + 1))
        #! right points to the answer and left is on the right side of the right pointer
        # left = 0 
        # right = len(h_index) - 1
        # while left <= right:
        #     mid = (left + right) // 2
        #     if citations[-mid] < h_index[mid]:
        #         right = mid - 1
        #     else:
        #         left = mid + 1
        # return h_index[left -1]

        #! both left and right points to the answer
        # left = -1
        # right = len(h_index) - 1 
        # while left < right:
        #     mid = (left + right + 1) // 2
        #     if citations[-mid] >= h_index[mid]:
        #         left = mid
        #     else:
        #         right = mid - 1
        # return h_index[right] 

        #! Left points to the answer and right is on the right side of the left pointer
        # left = -1
        # right = len(h_index) 
        # while left + 1 < right:
        #     mid = (left + right) // 2
        #     if citations[-mid] >= h_index[mid]:
        #         left = mid
        #     else:
        #         right = mid 
        # return left

        #! Left and right points to the right side of the answer:
        # left = 0
        # right = len(h_index)
        # while left < right:
        #     mid = (left + right) // 2
        #     if citations[-mid] >= h_index[mid]:
        #         left = mid + 1
        #     else:
        #         right = mid
        # return h_index[left - 1]



        #todo treating left and right directly as the answer
# @lc code=end

