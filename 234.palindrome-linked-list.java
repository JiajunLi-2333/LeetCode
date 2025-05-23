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
        int num = 0;
        ListNode traverse = head;
        while(traverse != null){
            num++;
            traverse = traverse.next;
        }
        ListNode[] list = new ListNode[num];

        for(int i = 0; i < num; i++){
            list[i] = head;
            head = head.next;
        }

        for(int i = 0; i < num; i++){
            if (list[i].val != list[num - i -1].val ){
                return false;
            }
        }
        return true;

    }
}
// @lc code=end

