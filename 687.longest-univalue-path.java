/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left == null && root.right == null){
            return 0;
        }
        if(root.left != null && root.left.val == root.val){
            left = left + 1;
        }else{left = 0;}
        if(root.right != null && root.right.val == root.val){
            right = right + 1;
        }else{right = 0;}
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
// @lc code=end

