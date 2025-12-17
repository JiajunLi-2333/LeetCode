/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        // ListNode odd = head;
        // if(odd == null){
        //     return head;
        // }
        // ListNode even = head.next, cur = head.next;
        // if(even == null || even.next == null){
        //     return head;
        // }
        // while(odd.next != null && even.next != null){
        //     //change the nodes
        //     odd.next = even.next;
        //     even.next = even.next.next;
        //     odd = odd.next;
        //     even = even.next;
        // }
        // odd.next = cur;
        // return head;
        //! 双指针标记链表头
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = head, even = head.next, cur = head.next;

        while(odd.next != null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = cur;
        return head;

    }
}
// @lc code=end

