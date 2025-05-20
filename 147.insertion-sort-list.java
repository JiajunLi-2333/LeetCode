/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        //Initialized a new dymmy node (note attached to the head linkedlist)
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode tmp = dummy;

        while(cur != null){
            while(tmp.next != null  && tmp.next.val < cur.val){
                tmp = tmp.next;
            }
            ListNode next = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            cur = next;
            tmp = dummy;
        }
        return dummy.next;
        
    }
}
// @lc code=end

