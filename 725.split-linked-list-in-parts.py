#
# @lc app=leetcode id=725 lang=python3
#
# [725] Split Linked List in Parts
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional,List
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        if not head: return [None] * k
        nodes = 0
        cur = head
        #find the number of nodes in the linked list
        while cur:
            nodes += 1
            cur = cur.next
        ans = []
        cur = head 
        a,b = divmod(nodes, k)
        while k:
            if not cur: break
            #find the size of each part
            ans.append(cur)
            part = a + (1 if b > 0 else 0)
            b -= 1 
            for i in range(part-1):
                cur = cur.next 
            #add the part to the ans list
            temp = cur.next
            cur.next = None
            cur = temp
            k -= 1
        #add None to the remaining parts
        ans += [None] * k
        return ans

# @lc code=end

