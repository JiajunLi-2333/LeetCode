#
# @lc app=leetcode id=147 lang=python3
#
# [147] Insertion Sort List
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional 
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    #todo Cheating method using list
    #     valist = []
    #     for node in self.iterate(head):
    #         valist.append(node.val)
    #     valist.sort()
    #     sorted_head = ListNode(0)
    #     current = sorted_head
    #     for val in valist:
    #         current.next = ListNode(val)
    #         current = current.next
    #     return sorted_head.next
    # def iterate(self, head):
    #     while head:
    #         yield head
    #         head = head.next
        if  not head or not head.next:
            return head

        dummy = ListNode()
        dummy.next = head
        cur = head.next
        prev = head

        while cur:
            if cur.val >= prev.val:
                prev = cur
                cur = cur.next
            else:
                tmp = dummy
                prev.next = cur.next
                while tmp.next and tmp.next.val < cur.val:
                    tmp = tmp.next
                cur.next = tmp.next
                tmp.next = cur
                cur = prev.next
        return dummy.next

                


        
# @lc code=end

