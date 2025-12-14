/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        // if(head == null || head.next == null) return head;
        // int cnt = 0;
        // ListNode traverse = head;//traverse is already the last node in the linked list
        // while(traverse.next != null){
        //     cnt++;
        //     traverse = traverse.next;
        // }
        // cnt += 1; 
        // //the relationship between k and cnt
        // int num = k % cnt;
        // if(num == 0){
        //     return head;
        // }
        // ListNode dummy = new ListNode(0, head);
        // ListNode right = dummy;
        // for(int i = 0; i < cnt - num; i++){
        //     right = right.next;
        // }
        // traverse.next = dummy.next;
        // dummy.next = right.next;
        // right.next = null;
        // return dummy.next;

        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int cnt = 0;
        while(cur.next != null){ //要想好结束时，节点的位置在哪里
            cnt++;
            cur = cur.next;
        }
        cnt += 1;
        
        int num = k % cnt;
        if(num == 0) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pos = dummy;
        
        for(int i = 0; i < cnt - num; i++){
            pos = pos.next;
        }

        //节点的交换 增删改查的基本功
        cur.next = dummy.next;
        dummy.next = pos.next;
        pos.next = null;
        return dummy.next;



    }
}
// @lc code=end

