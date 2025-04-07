#
# @lc app=leetcode id=2058 lang=python3
#
# [2058] Find the Minimum and Maximum Number of Nodes Between Critical Points
#

# @lc code=start
from typing import Optional, List
from math import inf
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
            index = 1
            a,b,c  = head, head.next, head.next.next
            last, first, min_dist = 0,0,inf
            while c:
                if c.val < b.val > a.val or c.val > b.val < a.val:
                    if first == 0:
                        first = index
                    if last > 0 and index - last < min_dist:
                         min_dist = index - last
                    last = index
                a,b,c = b,c,c.next
                index += 1
            return [min_dist, last - first] if last != first else [-1, -1]

               



        
# @lc code=end

