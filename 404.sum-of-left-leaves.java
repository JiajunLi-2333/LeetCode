/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        // 判断左子节点是否是叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += dfs(root.left);  // 左子节点不是叶子，继续递归
        }
        
        sum += dfs(root.right);  // 递归右子树
        
        return sum;
    }
}

// @lc code=end

// @lc code=end

