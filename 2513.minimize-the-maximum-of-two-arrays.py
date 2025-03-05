#
# @lc app=leetcode id=2513 lang=python3
#
# [2513] Minimize the Maximum of Two Arrays
#

# @lc code=start
import math
class Solution:
    def minimizeSet(self, divisor1: int, divisor2: int, uniqueCnt1: int, uniqueCnt2: int) -> int:
        #This question can be translated into a binary search problem of finding the minimum
        def check(mx: int) -> bool:
            # check whether the given mx cound be distributed into arr1 and arr2 that satisfy the condition
            # return True if it is possible, otherwise False
            # Count numbers not divisible by divisor1.
            count1 = mx - (mx // divisor1)
            # Count numbers not divisible by divisor2.
            count2 = mx - (mx // divisor2)
            # Compute least common multiple of divisor1 and divisor2.
            lcm = divisor1 * divisor2 // math.gcd(divisor1, divisor2)
            # Count numbers not divisible by either divisor.
            countCommon = mx - ((mx // divisor1) + (mx // divisor2) - (mx // lcm))
            
            # Check individual requirements and the total distinct count.
            return (count1 >= uniqueCnt1 and 
                    count2 >= uniqueCnt2 and 
                    (count1 + count2 - countCommon) >= (uniqueCnt1 + uniqueCnt2))
        #initialize the left and right pointers
        left, right = (uniqueCnt1 + uniqueCnt2 - 1), divisor1 * divisor2 * (uniqueCnt1 + uniqueCnt2)
        while left + 1 < right:
            mid = (left + right) // 2  
            if check(mid):
                right = mid
            else:
                left = mid
        return right
# @lc code=end

