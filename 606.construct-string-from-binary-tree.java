/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    private StringBuilder ans = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return ans.toString();
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        ans.append(root.val);
        if(root.left != null && root.right != null){
            ans.append("(");
            dfs(root.left);
            ans.append(")");
        }
        if(root.right != null){
            ans.append("(");
            dfs(root.right);
            ans.append(")");
        }
    }
}
// @lc code=end

