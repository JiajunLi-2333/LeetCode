/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
class Solution {
    // int count = 0;
    public int goodNodes(TreeNode root) {
        // dfs(root, Integer.MIN_VALUE);
        // return count;
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int max){
        if(root == null) return 0;
        int cur = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        return cur + dfs(root.left, max) + dfs(root.right, max);

    }
    // public void dfs(TreeNode node, int max){
    //     if(node == null) return;
    //     if(node.val >= max){
    //         count++;
    //         max = node.val;
    //     }
    //     dfs(node.left, max);
    //     dfs(node.right, max);
    // }
    
}
// @lc code=end

