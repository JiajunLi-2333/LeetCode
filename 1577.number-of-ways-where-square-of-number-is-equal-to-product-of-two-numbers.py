#
# @lc app=leetcode id=1577 lang=python3
#
# [1577] Number of Ways Where Square of Number Is Equal to Product of Two Numbers
#

# @lc code=start
from typing import List
class Solution:
    def numTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        #No Unique requirement
        #i

        #two pointer helper function



        def count_triplet(n1: List[int], n2: List[int]) -> int:
            count = 0
             #! the first approach works, but TLE for many duplicated pairs
            # for i in range(len(n1)):
            #     target = n1[i] ** 2
            #     for j in range(len(n2)):
            #         right =  len(n2) - 1
            #         while j < right:
            #             cur = n2[j] * n2[right]
            #             if cur == target:
            #                 count += 1
            #                 right -= 1
            #             elif cur > target:
            #                 right -= 1
            #             else:
            #                 break
            # return count

            #! Optimized approach: jumping on the duplicated pairs
            for i in range(len(n1)):
                cnt = 0
                target = n1[i] ** 2

                left = 0
                right = len(n2) - 1

                while left < right:
                    cur = n2[left] * n2[right]
                    #Below is all mathematical counting logic
                    if cur == target:
                        if n2[left] == n2[right]:
                            count += (right - left + 1) * (right - left) // 2
                            break
                        else:
                            left_cnt = 1
                            right_cnt = 1
                            while left + 1 < right and n2[left] == n2[left + 1]:
                                left += 1
                                left_cnt += 1
                            while right - 1 > left and n2[right] == n2[right - 1]:
                                right -= 1
                                right_cnt += 1
                            count += left_cnt * right_cnt
                            left += 1
                            right -= 1
                    elif cur > target:
                        right -= 1
                    else:
                        left += 1
            return count
        nums1.sort()
        nums2.sort()
        return count_triplet(nums1, nums2) + count_triplet(nums2, nums1)



        
# @lc code=end

