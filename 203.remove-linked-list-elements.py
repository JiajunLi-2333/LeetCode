#
# @lc app=leetcode id=203 lang=python3
#
# [203] Remove Linked List Elements
#

# @lc code=start
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        #if use dummy node, it will be easier to handle the head node
        # dummy = ListNode(0)
        # dummy.next = head
        # cur = dummy
        # while cur:
        #     if cur.next and cur.next.val == val:
        #         cur.next = cur.next.next
        #     else:
        #         cur = cur.next
        # return dummy.next 
        # if not use dummy node, we need to handle the head node separately
        cur = head
        while cur:
            while cur.next and cur.next.val == val:
                cur.next = cur.next.next
            cur = cur.next
        if head and head.val == val:
            head = head.next
        return head
        
# @lc code=end

