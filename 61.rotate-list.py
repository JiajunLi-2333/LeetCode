#
# @lc app=leetcode id=61 lang=python3
#
# [61] Rotate List
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #! TLE
        # if not head or head.next is None:
        #     return head
        # dummy = ListNode(next = head)
        # for i in range(k):
        #     right = dummy.next
        #     left = dummy
        #     #use left as the node previous to the last node
        #     while right.next:
        #         right = right.next
        #         left = left.next
            
        #     nxt = left.next
        #     nxt.next = dummy.next
        #     dummy.next = nxt
        #     left.next = None
        # return dummy.next
        #todo Change elements accordingly
        if not head or head.next is None:
            return head
        dummy = ListNode(next = head)
        length = 0
        cur = head
        while cur:
            length += 1 
            cur = cur.next
        remainder = k % length

        left = right = dummy
        for _ in range(remainder):
            right = right.next
        while right.next:
            left = left.next
            right = right.next
        
        #modify the linked list
        right.next = dummy.next
        dummy.next = left.next
        left.next = None
        return dummy.next
   
# @lc code=end

