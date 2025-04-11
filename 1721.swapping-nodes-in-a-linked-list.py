#
# @lc app=leetcode id=1721 lang=python3
#
# [1721] Swapping Nodes in a Linked List
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional 
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = left = right = first = ListNode(next = head)
        for i in range(k):
            right = right.next
            #now we have reached the first node 
            first = first.next
        
        while right.next:
            right = right.next
            #now left is the node previous to the kth node from the end
            left = left.next
        
        #exchange the value of the two nodes
        val = first.val
        second = left.next 
        first.val = second.val
        second.val = val
        return dummy.next

# @lc code=end

