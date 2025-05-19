/*
 * @lc app=leetcode id=1290 lang=java
 *
 * [1290] Convert Binary Number in a Linked List to Integer
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
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>(); 
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int res = 0;
        for(int i = 0; i < list.size(); i++){
            res += list.get(i) * Math.pow(2, list.size() - 1 - i);
        }
        return res;

    }
}
// @lc code=end

