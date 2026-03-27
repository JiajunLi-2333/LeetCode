/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */
import java.util.*;

/*
Optimize:
the monotonic stack can maintain two things:
Optimize: 1. from left to right, the stack maintains the candidate, the ones who has not yet found the next greater element. 
Optimize: 2. from right to left, the stack maintains the next greater element.
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
import java.util.*;
class Solution {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private int[] ans;
    public int[] nextLargerNodes(ListNode head) {
        // List<Integer> nums = new ArrayList<>();
        // while(head != null){
        //     nums.add(head.val);
        //     head = head.next;
        // }
        // Deque<Integer> stack = new ArrayDeque<>();
        // int[] ans = new int[nums.size()];
        // Arrays.fill(ans, 0);
        // for(int i = 0; i < nums.size();i++){
        //     while(!stack.isEmpty() && nums.get(i) > nums.get(stack.peek())){
        //         int j = stack.pop();
        //         ans[j] = nums.get(i);
        //     }
        //     stack.push(i);
        // }
        // return ans;
        recur(head, 0);
        return ans;
    }
    //TODO Faster recursion
    private void recur(ListNode head, int i){
        if(head == null){
            ans = new int[i];
            return; 
        }
        recur(head.next, i + 1);
        while(!stack.isEmpty() && stack.peek() <= head.val){
            stack.pop();
        }
        if(!stack.isEmpty()){
            ans[i] = stack.peek();
        }
        stack.push(head.val);

    }
}
// @lc code=end

