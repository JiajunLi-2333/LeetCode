/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    TreeNode ans;
    int maxDepth = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0); 
        return ans;
    }
    private int dfs(TreeNode root, int depth){
        if(root == null){
            maxDepth = Math.max(depth,maxDepth);
            return depth;
        }
        int leftMax = dfs(root.left, depth + 1);
        int rightMax = dfs(root.right, depth + 1);
        if(leftMax == rightMax && leftMax == maxDepth){
            ans = root;
        }
        return Math.max(leftMax, rightMax);
    }
}
// @lc code=end

