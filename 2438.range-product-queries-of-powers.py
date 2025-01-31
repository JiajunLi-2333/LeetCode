#
# @lc app=leetcode id=2438 lang=python3
#
# [2438] Range Product Queries of Powers
#

# @lc code=start
class Solution:
    def productQueries(self, n: int, queries: list[list[int]]) -> list[int]:
        MOD = 10**9 + 7
        
        # 1) Collect the powers of two from n's binary representation
        #    In ascending order of bit positions (LSB -> MSB).
        powers_array = []
        bit_pos = 0
        temp = n
        while temp > 0:
            if temp & 1:
                powers_array.append(pow(2, bit_pos, MOD))
            bit_pos += 1
            temp >>= 1
        
        # 2) Answer each query by multiplying the relevant slice of powers_array
        result = []
        for left, right in queries:
            product = 1
            for i in range(left, right + 1):
                product = (product * powers_array[i]) % MOD
            result.append(product)
        
        return result
        

        
        
# @lc code=end

