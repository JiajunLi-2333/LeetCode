/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        int cnt = 0;
        ListNode traverse = head;
        while(traverse != null){
            cnt += 1;
            traverse = traverse.next;
        }
        int middle = cnt/2;
        ListNode middleNode = head;
        for(int i = 0; i < middle; i++){
            middleNode = middleNode.next;
        }
        return middleNode;
        
    }
}
// @lc code=end

