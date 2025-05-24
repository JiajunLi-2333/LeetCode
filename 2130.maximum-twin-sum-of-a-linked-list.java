/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {
        int ans = Integer.MIN_VALUE;
        ListNode mid = middle(head);
        ListNode head2 = reverse(mid);
        while(head2 != null){
            ans = Math.max(ans, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        return ans;
    }
    private ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur; 
            cur = next;
        }
        return prev;
    }
}
// @lc code=end

