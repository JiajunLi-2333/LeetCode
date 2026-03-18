/*
 * @lc app=leetcode id=2415 lang=java
 *
 * [2415] Reverse Odd Levels of Binary Tree
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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    //TODO 同时传两个节点进DFS
    
    private void dfs(TreeNode left, TreeNode right, int level){
        if(left == null) return;
        if(level % 2 == 1){
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }
        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }
}
// @lc code=end

