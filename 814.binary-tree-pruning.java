/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if(left == null && right == null && root.val == 0){
            return null;
        }
        if(left == null){
            root.left = null;
        }
        if(right == null){
            root.right = null;
        }
        return root;
    }
}
// @lc code=end

