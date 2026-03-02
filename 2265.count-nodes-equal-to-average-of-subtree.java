/*
 * @lc app=leetcode id=2265 lang=java
 *
 * [2265] Count Nodes Equal to Average of Subtree
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
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    //int[0] = sum of subtree int[1] number of nodes
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0}; 
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        if(sum / n == root.val) ans++;
        return new int[]{sum,n};         
    }
}
// @lc code=end

