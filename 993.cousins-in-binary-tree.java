/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    private int depth;
    private TreeNode father;

    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root, null, 1, x, y);
    }

    private boolean dfs(TreeNode node, TreeNode fa, int d, int x, int y) {
        if (node == null) {
            return false;
        }
        if (node.val == x || node.val == y) { // 找到 x 或 y
            if (depth > 0) { // 之前已找到 x y 其中一个
                return depth == d && father != fa;
            }
            depth = d; // 之前没找到，记录信息
            father = fa;
        }
        return dfs(node.left, node, d + 1, x, y) || dfs(node.right, node, d + 1, x, y);
    }
}
// @lc code=end

