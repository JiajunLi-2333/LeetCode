#
# @lc app=leetcode id=1290 lang=python3
#
# [1290] Convert Binary Number in a Linked List to Integer
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        # a= ''
        # while head:
        #     a += str(head.val)
        #     head = head.next
        # return int(a, 2)

        #todo alternative soltion
        #it is just too slow but it works just fine mua
        cnt = 0
        ans = 0
        binary_list = []
        while head:
            binary_list.append(int(head.val))
            cnt += 1
            head = head.next
        
        for ele in binary_list:
            ans += ele * (2 ** (cnt-1))
            cnt -= 1
        return ans
        
# @lc code=end

