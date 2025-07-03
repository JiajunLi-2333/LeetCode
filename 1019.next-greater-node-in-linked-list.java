/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */
import java.util.Arrays;
import java.util.Stack;
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
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        int idx = 0, n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] ans = new int[n];
        cur = head;
        while(cur != null){
            while(!stack.isEmpty() && stack.peek()[0] < cur.val){
                int[] top = stack.pop();
                ans[top[1]] = cur.val;
            }
            stack.push(new int[] {cur.val, idx});
            idx++;
            cur = cur.next;
        }
        return ans;        
    }
}
// @lc code=end

