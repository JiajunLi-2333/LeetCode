/*
 * @lc app=leetcode id=2181 lang=java
 *
 * [2181] Merge Nodes in Between Zeros
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
    public ListNode mergeNodes(ListNode head) {
        ListNode cur = head.next;
        ListNode concate = head;
        while(cur.next != null){
            if(cur.val != 0){
                concate.val += cur.val;
            }
            else{
                concate = concate.next;
                concate.val = 0;
            }
            cur = cur.next;
        }
        concate.next = null;
        return head;
    }

}
// @lc code=end

