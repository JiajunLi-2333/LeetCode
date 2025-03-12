#
# @lc app=leetcode id=923 lang=python3
#
# [923] 3Sum With Multiplicity
#

# @lc code=start
from typing import List
from collections import Counter
class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        # i < j < k
        #arr[i] + arr[j] + arr[k] == target
        #1 1 2 2 2 5 5 
        MOD = 10**9 + 7
        arr.sort()
        ans = 0
        for i in range(len(arr)):
            target2 = target - arr[i]
            j, k = i + 1, len(arr) - 1
            while j < k:
                cur = arr[j] + arr[k]
                if cur < target2:
                    j += 1
                elif cur > target2:
                    k -= 1
                else:
                    if arr[j] == arr[k]:
                        #k - j + 1 is the sum of first and last element
                        #k - j is total number of elements
                        ans += ((k - j + 1) * (k - j) // 2) % MOD
                        break
                    else:
                        left = right = 1
                        while j + 1 < k and arr[j] == arr[j + 1]:
                            j += 1
                            left += 1
                        while k - 1 > j and arr[k] == arr[k - 1]:
                            k -= 1
                            right += 1
                        ans += (left * right) % MOD
                        j += 1
                        k -= 1
        return ans % MOD
# @lc code=end

