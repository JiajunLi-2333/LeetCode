/*
 * @lc app=leetcode id=1080 lang=java
 *
 * [1080] Insufficient Nodes in Root to Leaf Paths
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
    private int limit;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
       this.limit = limit;
       return dfs(root, 0);
    }
    private TreeNode dfs(TreeNode root, int sum){
        if(root == null){
            return null;
        }
        sum += root.val;
        boolean isLeaf = (root.left == null && root.right == null);
        root.left = dfs(root.left, sum );
        root.right = dfs(root.right, sum);
        if(isLeaf){
            return sum >= limit ? root : null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
// @lc code=end

