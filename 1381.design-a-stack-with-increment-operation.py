#
# @lc app=leetcode id=1381 lang=python3
#
# [1381] Design a Stack With Increment Operation
#

# @lc code=start
class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = []
        self.count = 0
        self.maxSize = maxSize
    def push(self, x: int) -> None:
        if self.count < self.maxSize:
            self.stack.append(x)
            self.count += 1 
    def pop(self) -> int:
        if not self.stack:
            return -1
        self.count -= 1
        return self.stack.pop()
    def increment(self, k: int, val: int) -> None:
        if k > self.count:
            for i in range(self.count):
                self.stack[i] += val
        else:
            for i in range(k):
                self.stack[i] += val
        


# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)
# @lc code=end

