/*
 * @lc app=leetcode id=1290 lang=java
 *
 * [1290] Convert Binary Number in a Linked List to Integer
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
    //算法技巧在于数学运算
    public int getDecimalValue(ListNode head) {
        // head = reverse(head);
        // int ans = 0;
        // int base = 1;
        // while (head != null) {
        //     ans += head.val * base;
        //     base *= 2;
        //     head = head.next;
        // }
        // return ans;
        int ans = 0;
        while(head != null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }
    // private ListNode reverse(ListNode head){
    //     ListNode prev = null;
    //     ListNode cur = head;
    //     while(cur != null){
    //         ListNode next = cur.next;
    //         cur.next = prev;
    //         prev = cur;
    //         cur = next;
    //     }
    //     head = prev;
    //     return head;
    // }
}
// @lc code=end

