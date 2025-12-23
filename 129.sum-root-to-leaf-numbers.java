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
        int ans = dfs(root, 0);
        return ans;
    }
    public int dfs(TreeNode node, int x){
        if(node == null){//左右子节点是空节点直接返回0
            return 0;
        }

        x = x * 10 + node.val;
        if(node.left == null && node.right == null){
            return x;
        }
        return dfs(node.left, x) + dfs(node.right, x);
    }
}
// @lc code=end

