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
        int sum = 0;
        if(node == null) return 0;
        if (grandparent != null && (grandparent.val % 2 == 0)){
            sum += node.val;
        }
        return dfs(node.left, node, parent) + dfs(node.right, node, parent) + sum;
    }
}
// @lc code=end

