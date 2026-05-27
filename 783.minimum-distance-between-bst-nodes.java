/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    int min = Integer.MAX_VALUE;
    int prev = - 1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if(prev != -1){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
    
}
// @lc code=end

