/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // int n = 0;
        // ListNode cnt = head;
        // ListNode dummy = new ListNode(0, head);
        // ListNode dummyhead = dummy;
        // ListNode cur = head;
        // while(cnt != null){
        //     n++;
        //     cnt = cnt.next;
        // }
        // int groups = n / k; // how many groups with length k we are able to reverse
        // while(groups > 0){
        //     ListNode prev = null;
        //     for(int i = 0; i < k; i++){
        //         ListNode next = cur.next;
        //         cur.next = prev;
        //         prev = cur;
        //         cur = next;
        //     }
        //     ListNode first = dummyhead.next;
        //     first.next = cur;
        //     dummyhead.next = prev;
        //     dummyhead = first;
        //     groups--; 
        // }
        // return dummy.next;

        int len = 0;
        ListNode cnt = head;
        while(cnt != null){
            len++;
            cnt = cnt.next;
        }
        int iter = len/k;

        ListNode dummy = new ListNode(0, head);
        ListNode tmp = dummy;
        ListNode cur = head;

        while(iter-- > 0){
            ListNode prev = null;
            for(int i = 0; i < k; i++){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode tail = tmp.next;
            tail.next = cur;
            tmp.next = prev;
            tmp = tail;
        }
        return dummy.next;

        
        
    }
}
// @lc code=end

