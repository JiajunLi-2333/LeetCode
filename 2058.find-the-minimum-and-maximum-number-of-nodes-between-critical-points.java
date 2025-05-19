/*
 * @lc app=leetcode id=2058 lang=java
 *
 * [2058] Find the Minimum and Maximum Number of Nodes Between Critical Points
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        int prevCritical = -1; // the location of the previous critical point
        int firstCritical = -1; // the location of the first critical point
        ListNode prev = head; 
        ListNode cur = head.next;
        int min = Integer.MAX_VALUE;
        int index = 1;
        int lastindex = 0;
        while(cur.next != null){
            if(prev.val < cur.val && cur.val > cur.next.val || prev.val > cur.val && cur.val < cur.next.val){
                if(firstCritical == -1){
                    firstCritical = index;
                    prevCritical = index;
                    lastindex = index;
                }
                else{
                    min = Math.min(min, index - prevCritical);
                    lastindex = index;
                }
                prevCritical = index;
            }
            prev = cur;
            cur = cur.next;
            index++;
        }
        if(min == Integer.MAX_VALUE){
            return ans;
        }
        ans[0] = min;
        ans[1] = lastindex - firstCritical;
        return ans;
    }

}

// @lc code=end

