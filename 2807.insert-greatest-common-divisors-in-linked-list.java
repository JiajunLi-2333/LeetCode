/*
 * @lc app=leetcode id=2807 lang=java
 *
 * [2807] Insert Greatest Common Divisors in Linked List
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            int gcd = gcd(cur.val, cur.next.val);
            ListNode next = cur.next;
            ListNode newNode = new ListNode(gcd);
            cur.next = newNode;
            newNode.next = next;
            cur = cur.next.next;
        }
        return head;
    }

    private int gcd(int a, int b){
        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;

    }
}
// @lc code=end

