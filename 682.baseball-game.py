#
# @lc app=leetcode id=682 lang=python3
#
# [682] Baseball Game
#

# @lc code=start
from typing import List
class Solution:
    def calPoints(self, operations: List[str]) -> int:
        #Start with an empty score
        ans = []
        for op in operations:
            if op == "C":
                ans.pop()
            elif op == "D":
                ans.append(2 * ans[-1])
            elif op == "+":
                ans.append(ans[-1] + ans[-2])
            else:
                ans.append(int(op))
        return sum(ans)


# @lc code=end

