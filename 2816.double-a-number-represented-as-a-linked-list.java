/*
 * @lc app=leetcode id=2816 lang=java
 *
 * [2816] Double a Number Represented as a Linked List
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
    public ListNode doubleIt(ListNode head) {
        head = reverseIt(head);
        ListNode dummmy = new ListNode();
        ListNode cur = dummmy;
        int carry = 0;
        while(head != null || carry > 0 ){
            carry += head != null ? head.val *2 : 0;
            cur.next = new ListNode(carry % 10);
            carry /= 10;
            cur = cur.next;
            head = head != null ? head.next : null;
        }
        return reverseIt(dummmy.next);
    } 

    private ListNode reverseIt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// @lc code=end

