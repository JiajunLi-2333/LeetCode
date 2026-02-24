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
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, true);
        return ans;
    }
    private void dfs(TreeNode root, int len, boolean isLeft){//len作为参数状态跟随
        if(root == null) return;
        ans = Math.max(ans, len);

        dfs(root.left, isLeft ? 1 : len + 1,true);
        dfs(root.right, !isLeft ? 1 : len + 1,false);
    }
}
// @lc code=end

