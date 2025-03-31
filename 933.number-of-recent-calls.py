#
# @lc app=leetcode id=933 lang=python3
#
# [933] Number of Recent Calls
#

# @lc code=start
class RecentCounter:

    #Each test case will call ping with strictly increasing values of t
    #1 <= t <= 109

    def __init__(self):
        self.queue = []
        
    #The strictly increasing values of t means that we can use a queue to sovle the problem
    def ping(self, t: int) -> int:
        self.queue.append(t)
        while self.queue[0] < t - 3000:
            self.queue.pop(0) 
        return len(self.queue)
    
        


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
# @lc code=end

