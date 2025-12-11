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
        // int len = 0;
        // for(ListNode cur = head; cur != null; cur = cur.next){
        //     len++;
        // }
        // if (len == 0) return new ListNode[k]; 
        // int base = len / k;
        // int extra = len % k; 
        // ListNode[] ans = new ListNode[k];
        // ListNode cur = head;
        // int i = 0;
        // while (cur != null){
        //     int size = base + (i < extra ? 1:0);
        //     ans[i] = cur;
        //     for(int j = 0; j < size - 1; j++){
        //         cur = cur.next;
        //     }
        //     ListNode next = cur.next;
        //     cur.next = null;
        //     cur = next;
        //     i++;
        // } 
        // return ans;


        //没考察什么算法不算法的，这部分就是看链表运用的熟练不熟练

        //考察了一个取模运算的知识点
        int len = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            len++;
        }

        //if the node is empty, return a list of Node with length k
        if(len == 0) return new ListNode[k];

        int base = len / k; // the minimum number of nodes a part should have
        int addOn = len % k; // the number of parts that have one extra node, earlier parts to be specific

        ListNode[] ans = new ListNode[k];
        int index = 0; // used to insert into ans
        ListNode cur = head;

        while(cur != null){
            int size = base + (index < addOn ? 1: 0);
            ans[index++] = cur;
            for(int i = 0; i < size - 1; i++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans; 
        
    }
}
// @lc code=end

