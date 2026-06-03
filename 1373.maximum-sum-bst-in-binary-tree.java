/*
 * @lc app=leetcode id=1373 lang=java
 *
 * [1373] Maximum Sum BST in Binary Tree
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
    //! 二叉树性质 + 后序递归
    private int ans;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            };
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int val = root.val;
        if(val <= left[1] || val >= right[0]){
            return new int[]{
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0
            };
        }
        int sum = left[2] + right[2] + val;
        ans = Math.max(ans, sum);
        return new int[]{
            Math.min(val, left[0]),
            Math.max(right[1], val),
            sum
        };
    }
}
// @lc code=end

