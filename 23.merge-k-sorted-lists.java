/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */
import java.util.PriorityQueue;
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Use a min-heap to merge k sorted linked lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list: lists){
            if(list != null){
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                minHeap.offer(node.next);
            }
        }
        return dummy.next;

    }
}
// @lc code=end

