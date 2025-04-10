#
# @lc app=leetcode id=92 lang=python3
#
# [92] Reverse Linked List II
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = pointer = ListNode(next = head)
        for i in range(left -1):
            pointer = pointer.next
        prev = None
        cur = pointer.next
        for j in range(right - left + 1):
            node = cur.next
            cur.next = prev
            prev = cur
            cur = node
        pointer.next.next = cur
        pointer.next = prev
        return dummy.next
        

        
# @lc code=end

