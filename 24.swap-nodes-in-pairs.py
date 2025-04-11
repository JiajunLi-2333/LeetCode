#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #recursize method
        if head is None or head.next is None:
            return head
        
        node1 = head
        node2 = head.next
        node3 = node2.next

        node1.next = self.swapPairs(node3)
        node2.next = node1 

        return node2
        
        # if not head or head.next is None :
        #     return head
        # dummy = ListNode(next = head)
        # prev = dummy
        # cur  = head

        # while cur and cur.next:
        #     n_node = cur.next
        #     nn_node = cur.next.next
        #     prev.next = n_node
        #     cur.next = nn_node
        #     n_node.next = cur

        #     prev = cur
        #     cur = cur.next
        # return dummy.next
   
# @lc code=end

