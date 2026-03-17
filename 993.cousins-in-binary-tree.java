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

    private boolean dfs(TreeNode root, TreeNode parent, int d, int x, int y){
        if(root == null) return false;
        if(root.val == x || root.val == y){
            if(father != null){
                return depth == d && parent != father;
            }
            depth = d;
            father = parent;
        }
        return dfs(root.left, root, d + 1, x, y) || dfs(root.right, root, d + 1, x, y);
    }

    
}
// @lc code=end

