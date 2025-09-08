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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }
    private void dfs(TreeNode node, int sum){
        //可以开始归了 不用再继续传递下去了
        if(node == null) return;

        //传递过程中 需要的相同操作
        sum -= node.val;
        if(node.left == null && node.right == null){
            if(sum == 0) ans = true;
            return;
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
// @lc code=end

