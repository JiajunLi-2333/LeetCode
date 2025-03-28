#
# @lc app=leetcode id=2197 lang=python3
#
# [2197] Replace Non-Coprime Numbers in Array
#

# @lc code=start
from typing import List
import math
class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        # non-coprime numbers are numbers that GCD(a, b) > 1 

        def non_coprime(a: int, b: int) -> bool:
            # a and b are non-coprime if GCD(a, b) > 1 -> true
            # a and b are coprime if GCD(a, b) = 1 -> false
            return math.gcd(a, b) > 1
        
        # use stack to store the numbers
        stack = []
        i = 0
        while i < len(nums):
            if not stack:
                stack.append(nums[i])
            else:
                #check if the top of the stack and the current number are non-coprime
                if stack and non_coprime(stack[-1], nums[i]):
                    LCM = math.lcm(stack[-1], nums[i])
                    stack.pop()
                    while stack and non_coprime(stack[-1], LCM):
                        LCM = math.lcm(stack[-1], LCM)
                        stack.pop()
                    stack.append(LCM)
                else: 
                    stack.append(nums[i])
            i += 1
        return stack


        
# @lc code=end

