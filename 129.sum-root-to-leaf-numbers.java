/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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

    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);
    }
    private int dfs(TreeNode root, int val){
        if(root == null) return 0;
        val = val * 10 + root.val;
        if(root.left == null && root.right == null){return val;}
        int left = dfs(root.left, val);
        int right = dfs(root.right, val);
        return left + right;
    }

    
}
// @lc code=end

