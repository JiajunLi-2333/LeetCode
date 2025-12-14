/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        //todo solve using ListNode array
        // int num = 0;
        // ListNode traverse = head;
        // while(traverse != null){
        //     num++;
        //     traverse = traverse.next;
        // }
        // ListNode[] list = new ListNode[num];

        // for(int i = 0; i < num; i++){
        //     list[i] = head;
        //     head = head.next;
        // }

        // for(int i = 0; i < num; i++){
        //     if (list[i].val != list[num - i -1].val ){
        //         return false;
        //     }
        // }
        // return true;
        //todo solve it using the fast and slow pointers
        // ListNode mid = middleNode(head);
        // ListNode head2 = reverse(mid);
        // while(head2 != null){
        //     if(head.val != head2.val){
        //         return false;
        //     }
        //     head = head.next;
        //     head2 = head2.next;
        // }
        // return true;

    }
    // private ListNode middleNode(ListNode head){
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     while(fast != null && fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
    // private ListNode reverse(ListNode head){
    //     ListNode prev = null;
    //     ListNode cur = head;
    //     while(cur != null){
    //         ListNode next = cur.next;
    //         cur.next = prev;
    //         prev = cur;
    //         cur = next;
    //     }
    //     return prev;
    // }
}
// @lc code=end

