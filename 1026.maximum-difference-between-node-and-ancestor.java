/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
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
    private int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }
    private void dfs(TreeNode node, int curMax, int curMin){
        if(node == null) return;
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        maxDiff = Math.max(maxDiff, curMax - curMin);
        dfs(node.left, curMax, curMin);
        dfs(node.right, curMax, curMin);
    }
}
// @lc code=end

