/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    private int ans = Integer.MAX_VALUE;
    private int parentVal = -1;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(parentVal != -1){ans = Math.min(ans, Math.abs(parentVal - root.val));}
        parentVal = root.val;
        dfs(root.right);
    }
}
// @lc code=end

