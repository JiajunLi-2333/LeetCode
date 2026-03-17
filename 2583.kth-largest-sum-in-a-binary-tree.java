-- Active: 1753409371458@@127.0.0.1@5432@postgres
/*
 * @lc app=leetcode id=2583 lang=java
 *
 * [2583] Kth Largest Sum in a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // int level = 0;
        // Queue<TreeNode> queue = new ArrayDeque<>();
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     int n = queue.size();
        //     level++;
        //     long sum = 0;
        //     while(n-- > 0){
        //         TreeNode node = queue.poll();
        //         sum += (long) node.val;
        //         if(node.left != null) queue.add(node.left);
        //         if(node.right != null) queue.add(node.right);
        //     }
        //     maxHeap.offer(sum);
        // }
        // if(level < k){
        //     return -1;
        // }
        // for(int i = 0; i < k -1;i++){
        //     maxHeap.poll();
        // }
        // return maxHeap.peek();

        PriorityQueue<Long> pq = new PriorityQueue<>(k);
        // BFS
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            long sum = 0L;
            for (int i = que.size(); i > 0; i--) {
                TreeNode cur = que.poll();
                sum += cur.val;
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            if (pq.size() < k || sum > pq.peek()) {
                if (pq.size() == k) {
                    pq.poll();
                }
                pq.offer(sum);
            }
        }
        return pq.size() == k ? pq.peek() : -1;
    }
}
// @lc code=end

