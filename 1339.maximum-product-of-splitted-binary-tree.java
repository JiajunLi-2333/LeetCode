/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
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
    private long ans =  0;
    private final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        dfs(root,sum);
        return (int)(ans % MOD);

    }
    private long getSum(TreeNode root){
        if(root == null) return 0; 
        long left = getSum(root.left);
        long right = getSum(root.right);
        return left + right + root.val;
    }
    private long dfs(TreeNode root, long sum){
        if(root == null){
            return 0;
        }
        long left = dfs(root.left, sum);
        long right = dfs(root.right, sum);
        ans = Math.max(ans, Math.max(left * (sum - left), right * (sum - right)));
        return left + right + (long) root.val;
    }
}
// @lc code=end

