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
    private int maxDepth = -1; // 全局最大深度
    private TreeNode ans;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth); // 维护全局最大深度
            return depth;
        }

        int leftMaxDepth = dfs(node.left, depth + 1); // 获取左子树最深叶节点的深度
        int rightMaxDepth = dfs(node.right, depth + 1); // 获取右子树最深叶节点的深度

        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) {
            ans = node; // node 可能是答案
        }

        return Math.max(leftMaxDepth, rightMaxDepth); // 当前子树最深叶节点的深度
    }
}
// @lc code=end

