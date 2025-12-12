
import javax.swing.text.DefaultStyledDocument;

/*
 * @lc app=leetcode id=2487 lang=java
 *
 * [2487] Remove Nodes From Linked List
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
    public ListNode removeNodes(ListNode head) {

        if(head.next == null){
            return head;
        }
        ListNode node = removeNodes(head.next);
        if(node.val > head.val){
            return node;
        }
        head.next = node;
        return head;


        //the reverse linked list method comes from the recursive linkedlist method
        //we have to do it by reversing the linked list
    //     head = reverse(head);
    //     ListNode cur = head;
    //     while(cur.next != null){
    //         if(cur.val > cur.next.val){
    //             cur.next = cur.next.next;
    //         }
    //         else{
    //             cur = cur.next;
    //         }
    //     }
    //     return reverse(head);

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
    }





}
// @lc code=end

