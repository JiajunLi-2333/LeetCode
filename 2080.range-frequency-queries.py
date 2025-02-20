#
# @lc app=leetcode id=2080 lang=python3
#
# [2080] Range Frequency Queries
#

# @lc code=start
import bisect
from collections import defaultdict 
class RangeFreqQuery:
    def __init__(self, arr: list[int]):
        pos = defaultdict(list)
        for i, x in enumerate(arr):
            pos[x].append(i)
        self.pos = pos
    def query(self, left: int, right: int, value: int) -> int:
        return bisect.bisect_right(self.pos[value], right) - bisect.bisect_left(self.pos[value], left)

        


# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)
# @lc code=end

