#
# @lc app=leetcode id=895 lang=python3
#
# [895] Maximum Frequency Stack
#

# @lc code=start
from collections import defaultdict
class FreqStack:
    #how to know the frequency of each element in the stack
    #if same frequency, how to know which one is closer to the top

    #solution
    #1. maintain a hashmap to store the frequency of each element
    #2. maintain a hashmap to store the elements with the same frequency
    #3. maintain a variable to store the max frequency in the stack 
    def __init__(self):
        self.stack = []
        #The count of each element in the stack
        self.chashmap = defaultdict(int)
        #the list of elements with the same frequency
        self.freqhashmap = defaultdict(list)
        #the max frequency in the stack
        self.maxfreq = 0

    def push(self, val: int) -> None:
        self.chashmap[val] += 1
        count = self.chashmap[val]
        self.freqhashmap[count].append(val)
        self.maxfreq = max(self.maxfreq, count)
        

    def pop(self) -> int:
        ans = self.freqhashmap[self.maxfreq].pop()
        self.chashmap[ans] -= 1
        self.maxfreq -= 1 if not self.freqhashmap[self.maxfreq] else 0
        return ans
        


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()
# @lc code=end

