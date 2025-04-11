#
# @lc app=leetcode id=2074 lang=python3
#
# [2074] Reverse Nodes in Even Length Groups
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = head
        size = 2
        while prev.next:
            node = prev
            n = 0
            for _ in range(size):
                if not node.next:
                    break
                n += 1
                node = node.next
            if n % 2 == 1:
                prev = node
            else: 
                node = prev.next
                rev  = None
                for j in range(n):
                    node.next, node, rev = rev, node.next, node
                prev.next.next, prev.next, prev = node, rev, prev.next
            size += 1
        return head
                
        
# @lc code=end

