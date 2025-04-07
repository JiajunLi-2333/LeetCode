#
# @lc app=leetcode id=817 lang=python3
#
# [817] Linked List Components
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional, List
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def numComponents(self, head: Optional[ListNode], nums: List[int]) -> int:
        nums = set(nums)
        ans = 0
        while head:
            if head.val in nums:
                while head and head.val in nums:
                    head = head.next
                ans += 1
            else:
                head = head.next
        return ans
        
# @lc code=end

