#
# @lc app=leetcode id=346 lang=python3
#
# [346] Moving Average from Data Stream
#

# @lc code=start
from collections import deque
class MovingAverage:

    def __init__(self, size: int):
        self.size = size
        self.cnt = 0
        self.queue = deque()
        self.sum = 0
        
    def next(self, val: int) -> float:
        self.queue.append(val)
        self.sum += val
        self.cnt += 1
        if self.cnt <= self.size:
            return self.sum / self.cnt
        else:
            self.sum -= self.queue.popleft()
            self.cnt -=  1
            return self.sum /self.size
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)
# @lc code=end

