/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //use two nodes to finish the problem
        ListNode dummy = new ListNode(0, head);
        ListNode node1 = head;
        ListNode node2 = dummy;
        while(node1.next != null){
            n--;
            node1 = node1.next;
            if(n <= 0){
                node2 = node2.next;
            }
        }
        node2.next = node2.next.next;
        return dummy.next;
    }
}
// @lc code=end

