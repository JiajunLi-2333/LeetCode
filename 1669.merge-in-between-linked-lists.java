/*
 * @lc app=leetcode id=1669 lang=java
 *
 * [1669] Merge In Between Linked Lists
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // ListNode last_node = list2;
        // while(last_node.next != null){
        //     last_node = last_node.next;
        // }
        // ListNode cur = list1;
        // int index = 0;
        // ListNode a_1 = null;
        // ListNode b_1 = null;
        // while(cur != null){
        //     if(index == a - 1){
        //         a_1 = cur;
        //     }
        //     if(index == b + 1){
        //         b_1 = cur;
        //     }
        //     cur = cur.next;
        //     index++;
        // }
        // a_1.next = list2;
        // last_node.next = b_1;
        // return list1;


        
    }
}
// @lc code=end

