#
# @lc app=leetcode id=981 lang=python3
#
# [981] Time Based Key-Value Store
#

# @lc code=start
from collections import defaultdict
import bisect
class TimeMap:

    def __init__(self):
        store = defaultdict(list)
        self.store = store

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        #If the key does not exist, return an empty string
        #If the key exists, but the timestamp being asked is less than the smallest timestamp of the key, return an empty string
        if not self.store[key] or timestamp < self.store[key][0][1]:
            return ""
        #If the key exists, and the timestamp being asked is greater than the largest timestamp of the key, return the value of the largest timestamp
        if timestamp > self.store[key][-1][1]:
            return self.store[key][-1][0]
        
        #Below is the normal situation
        time_stamp_values = [i[1] for i in self.store[key]]
        idx = bisect.bisect_right(time_stamp_values, timestamp)
        return self.store[key][idx-1][0]
# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
# @lc code=end

