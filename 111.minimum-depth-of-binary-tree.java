/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    int depth = 0;
    int ans = 0;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
  
    }
    public void dfs(TreeNode node){
        if(node == null) return;
        depth++;
        if(node.left == null && node.right == null){
            ans = Math.min(ans, depth);
        }
        dfs(node.left);
        dfs(node.right);
        depth--;
    }
}
// @lc code=end

