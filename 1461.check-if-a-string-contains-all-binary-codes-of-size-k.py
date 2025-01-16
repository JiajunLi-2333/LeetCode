#
# @lc app=leetcode id=1461 lang=python3
#
# [1461] Check If a String Contains All Binary Codes of Size K
#
# @lc code=start
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        #! This is the slicing window solution
        #use set because it stores unique, unordered elements
        # string_binary_code = set()
        # current_binary_code = []
        # for i,c  in enumerate(s):
        #     #Enter the window
        #     #current_binary_code += c #! This works because of string concatenation
        #     current_binary_code.append(c)
        #     if i < k - 1:
        #         continue
        #     #Update all the status
        #     string_binary_code.add(str(current_binary_code))

        #     #Exit the window
        #     current_binary_code.pop(0)
        # return len(string_binary_code) == 2**k
    
        #! Use the bitwise operation to convert binary to decimal

        #! Bit operation:
        #! & - bitwise AND For each bit position, the result is 1 if both bits are 1, otherwise, the result is 0.
        #! | - bitwise OR For each bit position, the result is 1 if at least one of the bits is 1, otherwise, the result is 0.
        need = 1 << k
        got = [False]*need
        all_one = need - 1
        hash_val = 0

        for i in range(len(s)):
            # calculate hash for s[i-k+1:i+1]
            hash_val = ((hash_val << 1) & all_one) | (int(s[i]))
            # hash only available when i-k+1 > 0
            if i >= k-1 and got[hash_val] is False:
                got[hash_val] = True
                need -= 1
                if need == 0:
                    return True
        return False
    
    #This much faster in this case
# @lc code=end

