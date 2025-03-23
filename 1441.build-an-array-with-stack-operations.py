#
# @lc app=leetcode id=1441 lang=python3
#
# [1441] Build an Array With Stack Operations
#

# @lc code=start
from typing import List
class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        #Stack s =    bottom ->[1,2,3,4,5] <- top
        ans = []
        m = len(target)
        i, j = 1, 0
        while i <= n and j < m:
            ans.append("Push")
            if target[j] != i:
                ans.append("Pop")
            else:
                j += 1
            i += 1
        return ans

# @lc code=end

