

/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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
    private TreeNode last;
    public TreeNode increasingBST(TreeNode root) {
        // TreeNode dummy = new TreeNode(-1);
        // last = dummy;
        // dfs(root);
        // return dummy.right;
    }
    // public void dfs(TreeNode root){
    //     if(root == null) return;
    //     dfs(root.left);
    //     last.right = root;
    //     root.left = null;
    //     last = root;
    //     dfs(root.right);
    // }
}
// @lc code=end

