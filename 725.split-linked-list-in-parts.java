/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        //use division and modulo to get the size of each part
        int len = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            len++;
        }
        if (len == 0) return new ListNode[k]; 
        int base = len / k;
        int extra = len % k; 
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        int i = 0;
        while (cur != null){
            int size = base + (i < extra ? 1:0);
            ans[i] = cur;
            for(int j = 0; j < size - 1; j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
            i++;
        } 
        return ans;
        
    }
}
// @lc code=end

