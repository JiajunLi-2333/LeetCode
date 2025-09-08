/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }
    private int dfs(TreeNode node, TreeNode parent, TreeNode grandparent){
        if(node == null) return 0;//归的边界条件

        //递给左右子树
        int left = dfs(node.left, node, parent);
        int right = dfs(node.right, node, parent);
        return grandparent != null && grandparent.val % 2 == 0 ? node.val + left + right : left + right;//每个节点需要干什么
    }
}
// @lc code=end

