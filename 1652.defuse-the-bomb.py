#
# @lc app=leetcode id=1652 lang=python3
#
# [1652] Defuse the Bomb
#

# @lc code=start
class Solution:
    def decrypt(self, code: list[int], k: int) -> list[int]:

        #! I will use the brutal force first to check if it is right
        #! The time complexity is O(n + k)
        # result = [0]*len(code)
        # sum = 0

        # if k == 0:
        #     return result
        # if k > 0:
        #     #now we have the proper list
        #     for i in range(k):
        #         code.append(code[i])
            
        #     for i in range(len(code)):
        #         if i == 0:
        #             continue
        #         sum += code[i] 
        #         if i < k:
        #             continue
        #         result[i-k] = sum
        #         sum -= code[i-k+1]
        #     return result
        # else:
        #     for i in range(abs(k)):
        #         code.insert(0, code[-1-i])
        #     for i in range(len(code)- 1):
        #         sum += code[i]
        #         if i < abs(k) - 1:
        #             continue
        #         result[i-abs(k)+ 1] = sum
        #         sum -= code[i-abs(k)+ 1]
        #     return result
        #! The brutal force is correct, but it is not efficient
        #! What I miss is the trick to handle the circualr array
        #! We can use the modulo to fix the circular array
        #! Together with the slicing window, we can solve the problem

        result = [0]*len(code)
        if k == 0: 
            return result
        begin, end, window_sum = 1, k, 0
        if k < 0:
            begin, end = len(code) + k, len(code) - 1
        #Calculate the initial window sum
        for i in range (begin, end+1):
            window_sum += code[i]
        for i in range(len(code)):
            result[i] = window_sum
            #Here we use the module to hanlde the circular array
            #And thus updating the window sum
            window_sum -= code[begin % len(code)]
            window_sum += code[(end+1) % len(code)]
            begin += 1
            end += 1 
        return result       
# @lc code=end

