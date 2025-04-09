#
# @lc app=leetcode id=2807 lang=python3
#
# [2807] Insert Greatest Common Divisors in Linked List
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
from math import gcd
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur.next != None:
            GCD = gcd(cur.val, cur.next.val)
            node = ListNode(GCD)
            node.next = cur.next
            cur.next = node
            cur = cur.next.next
        return head
        
# @lc code=end

