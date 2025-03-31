#
# @lc app=leetcode id=362 lang=python3
#
# [362] Design Hit Counter
#

# @lc code=start
from collections import deque
class HitCounter:
    #All calls are strictly increasing: all the timestamp parameters made the function calls are strictly increasing 

    def __init__(self):
        self.queue = deque()

    def hit(self, timestamp: int) -> None:
        if self.queue and self.queue[-1][0] == timestamp:
            self.queue[-1][1] += 1
        else:
            self.queue.append([timestamp, 1])
    def getHits(self, timestamp: int) -> int:
        while self.queue and self.queue[0][0] <= timestamp - 300:
            self.queue.popleft()
        return sum(count for _, count in self.queue)

        
        


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
# @lc code=end

