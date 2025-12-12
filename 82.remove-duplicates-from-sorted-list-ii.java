/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        // ListNode dummy = new ListNode(-101);
        // dummy.next = head;
        // ListNode prev = dummy;
        // ListNode cur = head;
        // while(cur != null){
        //     if(cur.next != null && cur.val == cur.next.val){
        //         while(cur.next != null && cur.val == cur.next.val){
        //             cur = cur.next;
        //         }
        //         prev.next = cur.next;
        //         cur = cur.next;
        //     }
        //     else{
        //         prev = cur;
        //         cur = cur.next;
        //     }
        // }
        // return dummy.next;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

