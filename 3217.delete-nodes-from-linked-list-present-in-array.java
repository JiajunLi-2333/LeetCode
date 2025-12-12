/*
 * @lc app=leetcode id=3217 lang=java
 *
 * [3217] Delete Nodes From Linked List Present in Array
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
import java.util.HashSet;
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num); 
        // }
        // ListNode dummy = new ListNode();
        // dummy.next = head; 
        // ListNode cur = head;
        // ListNode prev = dummy;
        // while(cur != null){
        //     if(set.contains(cur.val)){
        //         prev.next = cur.next;
        //     }else{
        //         prev = cur;
        //     }
        //     cur = cur.next;

        // }
        // return dummy.next;


        // HashSet<Integer> set = new HashSet<>();
        // for(int num : nums) set.add(num);
        // ListNode dummy = new ListNode();
        // dummy.next = head;

        // ListNode cur = head;
        // ListNode prev = dummy;

        // while(cur != null){
        //     if(set.contains(cur.val)){
        //         prev.next = cur.next;
        //         cur = cur.next;
        //     }else{
        //         prev = cur;
        //         cur = cur.next;
        //     }
        // }
        // return dummy.next;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode dummy = new ListNode();
        dummy.next= head; 
        ListNode cur = dummy;

        while(cur.next != null){
            ListNode next = cur.next;
            if(set.contains(next.val)){
                cur.next = next.next;
            }else{
                cur = next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

