#
# @lc app=leetcode id=306 lang=python3
#
# [306] Additive Number
#

# @lc code=start
class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)
        ans = False

        #!use nested for loop to define the first two numbers
        for i in range(1, n):
            for j in range(i + 1 , n):
                first_num, second_num, remaining= num[0:i], num[i:j], num[j:]

                #! These are the cases where leading zeros are not allowed in the sequence
                if (len(first_num) > 1 and first_num[0] == "0") or (len(second_num) > 1 and second_num[0] == "0"):
                    continue
                while remaining:
                    sum_num = str(int(first_num) + int(second_num))

                    if remaining.startswith(sum_num):
                        first_num, second_num, remaining = second_num, sum_num, remaining[len(sum_num):]
                    else:
                        break
                if remaining == "":
                    ans = True
                
                
        return ans
                








        
# @lc code=end

