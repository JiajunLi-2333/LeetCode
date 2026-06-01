/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    
    public void flatten(TreeNode root) {
        dfs(root, null);
    }
    private TreeNode dfs(TreeNode root, TreeNode prev){
        if(root == null) return prev;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(prev != null) prev.right = root;
        prev  = dfs(left, root);
        prev = dfs(right, prev);
        return prev;
    }
    
}
// @lc code=end

