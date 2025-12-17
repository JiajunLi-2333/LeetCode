/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        // if(head == null||head.next == null){
        //     return head;
        // }
        // ListNode smallDummy = new ListNode(0), bigDummy = new ListNode(0);
        // ListNode small = smallDummy, big = bigDummy;
        // while(head != null){
        //     if(head.val < x){
        //         small.next = head;
        //         small = head;
        //     }else{
        //         big.next = head;
        //         big = head;
        //     }
        //     head = head.next;
        // }
        // small.next = bigDummy.next;
        // big.next = null;
        // return smallDummy.next;
        
        
    }
}
// @lc code=end

