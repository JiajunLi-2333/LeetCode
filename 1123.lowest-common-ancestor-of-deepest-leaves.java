/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    private TreeNode ans;
    private int maxDepth = - 1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private int dfs(TreeNode root, int depth){
        if(root == null){
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftmaxDepth = dfs(root.left, depth + 1);
        int rightmaxDepth = dfs(root.right, depth  +1);
        if(leftmaxDepth == maxDepth && rightmaxDepth == maxDepth){
            ans = root;
        }
        return Math.max(leftmaxDepth, rightmaxDepth);

    }
}
// @lc code=end

