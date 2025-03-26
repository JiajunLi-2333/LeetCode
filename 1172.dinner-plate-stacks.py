#
# @lc app=leetcode id=1172 lang=python3
#
# [1172] Dinner Plate Stacks
#

# @lc code=start
class DinnerPlates:
    # constraint: 1 <= val <= 2 * 104
    # constraint: 1 <= capacity <= 2 * 104

    #Log: I indeed come up with the idea that we can use a stack to store all the plate stacks, this is pretty much the key to the solution

    #Log: Failed reason: I don't know what is heap and how can I use it. I should learn more about heap and how to use it in python

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.stack = []
        self.heap = []

    def push(self, val: int) -> None:
        
    def pop(self) -> int:

    def popAtStack(self, index: int) -> int:
        


# Your DinnerPlates object will be instantiated and called as such:
# obj = DinnerPlates(capacity)
# obj.push(val)
# param_2 = obj.pop()
# param_3 = obj.popAtStack(index)
# @lc code=end

