/*
 * @lc app=leetcode id=2095 lang=java
 *
 * [2095] Delete the Middle Node of a Linked List
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        int cnt = 0;
        ListNode traverse = head, middle = head;
        while(traverse != null){
            cnt += 1;
            traverse = traverse.next;
        }
        for(int i = 0; i < cnt/2 - 1; i++){
            middle = middle.next;
        }
        middle.next = middle.next.next;
        return head;
    }
}
// @lc code=end

