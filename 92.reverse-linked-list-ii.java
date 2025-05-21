/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        //now first is the node before the left index
        for(int i = 0; i < left - 1; i++){
            first = first.next;
        }

        ListNode prev = null;
        ListNode cur = first.next;
        for(int i = 0; i < right - left + 1; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        first.next.next = cur;
        first.next = prev;
        return dummy.next;
    }
}
// @lc code=end

