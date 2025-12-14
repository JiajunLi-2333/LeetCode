/*
 * @lc app=leetcode id=1721 lang=java
 *
 * [1721] Swapping Nodes in a Linked List
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
    public ListNode swapNodes(ListNode head, int k) {
        // if(head.next == null) return head;
        // int cnt = 0;
        // ListNode traverse = head;
        // while(traverse != null){
        //     cnt++;
        //     traverse = traverse.next;
        // }
        // ListNode fir = head, sec = head;
        // for(int i = 0; i < k -1; i++){
        //     fir = fir.next;
        // }
        // for(int j = 0; j < cnt - k; j++){
        //     sec = sec.next;
        // }
        // int val = fir.val;
        // fir.val = sec.val;
        // sec.val = val;
        // return head;


        //TODO complete it in one pass
        //! method of using fast and slow pointers
        // save redundant list traverse and complete in one pass 

        if(head == null || head.next == null) return head;

        ListNode first = head; 
        ListNode second = head;

        k -= 1;

        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            k--;
            if(k == 0){
                first = cur;
            }
            if(k < 0){
                second = second.next;
            }
        }
        int val = first.val;
        first.val  = second.val;
        second.val = val;
        return head;
    }
}
// @lc code=end

