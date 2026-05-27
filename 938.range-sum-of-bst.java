/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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
<<<<<<< HEAD
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        // if(root == null) return 0;
        // if(root.val >= low && root.val <= high){
        //     return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        // }
        // else if(root.val < low){
        //     return rangeSumBST(root.right, low, high);
        // }
        // else{
        //     return rangeSumBST(root.left, low, high);
        // } 
        dfs(root, low, high);
        return ans;
    }
    public void dfs(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low && root.val <= high){
            ans += root.val;
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        }
        else if(root.val < low){
            dfs(root.right, low, high);
        }
        else{
            dfs(root.left, low, high);
        }
    }
=======

    public int rangeSumBST(TreeNode root, int low, int high) {
       return dfs(root, low, high);
    }
    private int dfs(TreeNode root, int low, int high){
        if(root == null) return 0;
        int left = dfs(root.left, low, high);
        int right = dfs(root.right, low, high);
        if(root.val >= low && root.val <= high){
            return left + right + root.val;
        }
        return left + right;
    } 
>>>>>>> 52f035e (Inorder Recursion)
}
// @lc code=end

