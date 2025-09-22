/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null){
            ans += root.left.val;
        }
        
        dfs(root.right);
        
    }
}

// @lc code=end

// @lc code=end

