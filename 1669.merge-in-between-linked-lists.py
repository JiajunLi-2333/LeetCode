#
# @lc app=leetcode id=1669 lang=python3
#
# [1669] Merge In Between Linked Lists
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        index = 0
        cur = list1
        tmp = list2
        while tmp.next != None:
            tmp = tmp.next
        
        while cur:
            if index == a - 1:
                temp = cur.next
                cur.next = list2
                cur = temp
                #now cur is at the node after a -1 so increment the index
                index += 1
            elif index == b + 1:
                tmp.next = cur
                break
            else:
                cur = cur.next
                index += 1
        return list1
        # cur = list1
        # tmp = list2

        # #use tmp and the last node of list2
        # while tmp.next != None:
        #     tmp = tmp.next
        # while cur:
        #     if index == a -1:
        #         cur2 = cur.next
        #         index += 1 
        #         cur.next = list2
        #         while cur2:
        #             if index == b + 1:
        #                 tmp.next = cur2
        #                 break
        #             else:
        #                 cur2 = cur2.next
        #                 index += 1
        #     else:
        #         cur = cur.next
        #         index += 1
        # return list1
        # A, B = None, None
        # a -= 1
        # b += 1
        # ans = list1
        # while list1 and a > 0 and b > 0:
        #     list1 = list1.next
        #     a -= 1
        #     b -= 1
        # A = list1
        # while list1 and b > 0:
        #     list1 = list1.next
        #     b -= 1
        # B = list1
        # A.next = list2
        # while list2 and list2.next:
        #     list2 = list2.next
        # list2.next = B
        # return ans
        
        
        
# @lc code=end

