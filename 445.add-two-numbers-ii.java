/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 =reverse(l1);
        l2 = reverse(l2);
        ListNode result = addTwo(l1, l2, 0);
        return reverse(result);
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
    private ListNode addTwo(ListNode l1, ListNode l2, int sum){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2 != null || sum > 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int total = val1 + val2 + sum;
            sum = total / 10;
            cur.next = new ListNode(total % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
// @lc code=end

