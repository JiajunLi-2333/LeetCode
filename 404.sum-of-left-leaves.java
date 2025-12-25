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
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        int sum = 0; 
        if(node == null){
            return sum;
        }
        if(node.left != null && node.left.left == null && node.left.right == null){
            sum += node.left.val;
            return sum + dfs(node.right);
        }
        return dfs(node.left) + dfs(node.right);
    }
}
// @lc code=end

