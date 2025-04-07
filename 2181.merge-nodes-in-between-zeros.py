#
# @lc app=leetcode id=2181 lang=python3
#
# [2181] Merge Nodes in Between Zeros
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # sum = 0
        # cur = head
        # ans = ListNode(0)
        # tmp = ans
        # while cur:
        #     while cur.val != 0:
        #         sum += cur.val
        #         cur = cur.next
        #     if sum != 0:
        #         tmp.next = ListNode(sum)
        #         tmp = tmp.next
        #     cur = cur.next
        #     sum = 0
        # return ans.next
        sum = 0
        head2 = head
        cur = head.next
        while cur.next: 
            if cur.val == 0:
                head2 = head2.next
                head2.val = 0
            else:
                head2.val += cur.val
            cur = cur.next
        head2.next = None
        return head


        

# @lc code=end

