/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null ) return true;
        boolean left = isUnivalTree(root.left);
        boolean right = isUnivalTree(root.right);

        if(!left || !right) return false;
        if(root.left != null && root.left.val != root.val) return false;
        if(root.right != null && root.right.val != root.val) return false; 
        return true;
    }
}
// @lc code=end

