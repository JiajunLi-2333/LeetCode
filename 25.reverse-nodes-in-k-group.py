#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #Constraints:
        # 1 <= k <= n <= 5000
        # 0 <= Node.val <= 1000
        
        n = 0
        cur = head
        while cur:
            n += 1
            cur = cur.next
        
        dummy = pointer = ListNode(next = head)
        prev = None
        cur = head

        while n >= k:
            n -= k
            for _ in range(k):
                next_node = cur.next
                cur.next = prev
                prev = cur
                cur = next_node
            
            next_node = pointer.next
            next_node.next = cur
            pointer.next = prev
            pointer = next_node
        return dummy.next              
# @lc code=end

