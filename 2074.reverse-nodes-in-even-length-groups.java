/*
 * @lc app=leetcode id=2074 lang=java
 *
 * [2074] Reverse Nodes in Even Length Groups
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
import java.util.Stack;
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // int n = 0; //number of ndoes in the linkedlist
        // ListNode cnt = head;
        // while(cnt != null){
        //     n++;
        //     cnt = cnt.next;
        // }
        // if(n < 3){
        //     return head;
        // }
        // //When the swap actually occurs
        // ListNode cur = head.next;
        // ListNode anchor = head;
        // int num = 2;
        // n -= 1;
        // while(true){
        //     n -= num;
        //     if(n >= 0){
        //         if(num % 2 == 1){ //if the length is odd
        //             for(int i = 0; i< num; i++){
        //                 anchor = cur;
        //                 cur = cur.next;
        //             }
        //         }
        //         else{
        //             ListNode prev = null;
        //             for(int i = 0; i < num; i++){
        //                 ListNode next = cur.next;
        //                 cur.next = prev;
        //                 prev = cur;
        //                 cur = next;
        //             }
        //             ListNode last = anchor.next;
        //             last.next = cur;
        //             anchor.next = prev;
        //             anchor = last;
                
        //         }
        //         num++; //update the supposed len of the next loop
                
        //     }
        //     else{
        //         n += num;
        //         if(n % 2 == 1 || n == 0){
        //             break;
        //         }
        //         ListNode prev = null;
        //         for(int i = 0; i < n; i++){
        //             ListNode next = cur.next;
        //             cur.next = prev;
        //             prev = cur;
        //             cur = next;
        //         }
        //         ListNode last = anchor.next;
        //         last.next = cur;
        //         anchor.next = prev;
        //         break;
        
        //     }
        // }
        // return head;

        //TODO Maybe use two pointers and a stack can be better: change val only but not change the point direction
        
        int num = 1;
        ListNode cur = head; 
        while(cur != null){
            int cnt = 0; 
            ListNode tmp = cur;
            Stack<Integer> stack = new Stack<>();

            while(cnt != num && cur != null){
                stack.push(cur.val);
                cur = cur.next;
                cnt++;
            }

            if(cnt % 2 == 0){
                while(tmp != cur){
                    tmp.val = stack.pop();
                    tmp = tmp.next;
                }
            }
            num++;
        }
        return head; 

    }
}
// @lc code=end

