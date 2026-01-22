/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    // int curSum = 0;
    // boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // dfs(root, targetSum);
        // return ans;
        if(root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum); 
    }
    
    // public void dfs(TreeNode node, int targetSum){
    //     if(node == null) return;
    //     curSum += node.val;
    //     if(node.left == null && node.right == null){
    //         if(curSum == targetSum){
    //             ans = true;
    //             return; // early return if path sum is found
    //         }
    //     }
    //     dfs(node.left, targetSum);
    //     dfs(node.right, targetSum);
    //     curSum -= node.val;
    // }


}
// @lc code=end

