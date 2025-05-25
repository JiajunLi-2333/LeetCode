/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.HashSet;
import java.util.Set; 
public class Solution {
    public boolean hasCycle(ListNode head) {
        //  ListNode slow = head, fast = head;
        //  while(fast != null && fast.next != null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     if(fast == slow){
        //         return true;
        //     }
        // }
        // return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
// @lc code=end

