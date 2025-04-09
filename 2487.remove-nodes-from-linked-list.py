#
# @lc app=leetcode id=2487 lang=python3
#
# [2487] Remove Nodes From Linked List
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    #todo reverse the linked list and use iterative method to remove the nodes
    # def reverseNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
    #     prev = None
    #     cur = head
    #     while cur:
    #         next_node = cur.next
    #         cur.next = prev
    #         prev = cur
    #         cur = next_node
    #     return prev


    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # head = self.reverseNodes(head)
        # cur = head
        # while cur and cur.next:
        #     if cur.val > cur.next.val:
        #         cur.next = cur.next.next
        #     else:
        #         cur = cur.next
        # return self.reverseNodes(head)

        #todo use recursive method to remove the nodes
        if head.next is None:
            return head
        node = self.removeNodes(head.next)
        if node.val > head.val:
            return node
        head.next = node
        return head 
      
    
# @lc code=end