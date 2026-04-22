/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
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
    // private int ans = 0; 
    //TODO 
    private int ans = 0; 
    public int longestZigZag(TreeNode root) {
        dfs(root,true, 0);
        return ans;
    }
    private void dfs(TreeNode root, boolean isLeft, int len){
        if(root == null) return;
        ans = Math.max(ans, len);
        if(isLeft){
            dfs(root.left, true, 1);
            dfs(root.right, false, len +1);
        }
        else{
            dfs(root.left, true, len + 1);
            dfs(root.right, false, 1);
        }
    }
    
}
// @lc code=end

