/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode first = null, second = null, last = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(last != null && last.val > root.val){
            if(first == null){
                first = last;
                second = root;
            } else {
                second = root;
            }
        }  
        last = root;
        dfs(root.right);
    }
}
// @lc code=end

