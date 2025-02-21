#
# @lc app=leetcode id=1146 lang=python3
#
# [1146] Snapshot Array
#

# @lc code=start
from collections import defaultdict
import bisect
class SnapshotArray:
    #!This solution is not optimal, it uses too much memory
    #If snap is being called too many times, it will cause memory limit exceeded as here we are storing the whole array for each snap and snapshots is a dictionary of lists, which consumes a lot of memory
    # def __init__(self, length: int):
    #     self.snap_id = 0
    #     self.arr = [0] * length
    #     self.snapshots = defaultdict(list)

    # def set(self, index: int, val: int) -> None:
    #     self.arr[index] = val

    # def snap(self) -> int:
    #     self.snap_id += 1
    #     self.snapshots[self.snap_id - 1] = self.arr[:]
    #     return self.snap_id - 1

    # def get(self, index: int, snap_id: int) -> int:
    #     return self.snapshots[snap_id][index]

    #todo Better solution
    def __init__(self, length: int):
        self.snap_id = 0
        self.history = defaultdict(list)
    
    def set(self, index: int, val: int) -> None:
        self.history[index].append((self.snap_id, val))
    
    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1

    def get(self, index: int, snap_id: int) -> int:
        h_index = bisect.bisect_left(self.history[index], (snap_id + 1, )) - 1 
        return self.history[index][h_index][1] if h_index >= 0 else 0



# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
# @lc code=end

