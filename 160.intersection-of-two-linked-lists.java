/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // int A = 0, B = 0;
        // ListNode curA = headA, curB = headB;
        // for(ListNode cur = headA; cur != null; cur = cur.next){
        //     A++;
        // }
        // for(ListNode cur = headB; cur != null; cur = cur.next){
        //     B++;
        // }
        // if(A > B){
        //     for(int i = 0; i < A-B; i++){
        //         curA = curA.next;
        //     }
        // }
        // else{
        //     for(int i = 0; i < B - A; i++){
        //         curB = curB.next;
        //     }
        // }
        // while(curA != curB){
        //     curA = curA.next;
        //     curB = curB.next;
        // }
        // if (curA != null){
        //     return curA;
        // }
        // else{
        //     return null;
        // }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
}
// @lc code=end

