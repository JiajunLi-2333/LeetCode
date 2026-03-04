/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
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
    private int lTree, rTree = 0;
    private int x = 0; 
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lTree,rTree), n - 1 - lTree - rTree) * 2 > n;
    }

    private int dfs(TreeNode root){
        if(root == null){return 0;}
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.val == x){
            lTree = left;
            rTree = right;
        }
        return left + right + 1;
    }
}
// @lc code=end

