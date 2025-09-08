/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
        
    }
    // private void dfs(TreeNode node, int maxVal){
    //     if(node == null) return;
    //     if(node.val >=maxVal){
    //         ans++;
    //         maxVal = node.val;
    //     }
    //     dfs(node.left, maxVal);
    //     dfs(node.right, maxVal);
    // }
    private int dfs(TreeNode node, int maxVal){
        //处理边界 空节点开始归
        if(node == null) return 0;
        int left = dfs(node.left, Math.max(maxVal, node.val));
        int right = dfs(node.right, Math.max(maxVal, node.val));
        return (node.val >= maxVal ? 1 : 0) + left + right;//非边界条件 向下递

    }
}
// @lc code=end

