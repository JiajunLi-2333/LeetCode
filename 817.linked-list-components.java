/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
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
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        while(head != null){
            if(set.contains(head.val)){
                while(head != null  && set.contains(head.val)){
                    head = head.next;
                }
                ans++;
            }
            else{
                head = head.next;
            }
        }
        return ans; 

    }
}
// @lc code=end

