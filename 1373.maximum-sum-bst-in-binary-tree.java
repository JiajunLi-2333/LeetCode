/*
 * @lc app=leetcode id=1373 lang=java
 *
 * [1373] Maximum Sum BST in Binary Tree
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

    public int maxSumBST(TreeNode root) {
        
    }
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int val = root.val;
        if(val <= left[1] || val >= right[0]){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        return new int[]{}
    }
}
// @lc code=end

