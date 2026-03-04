/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    private boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root,subRoot);
        return ans;
    }
    private void dfs(TreeNode p, TreeNode q){
        if(p == null || ans) return;
        if(isSameTree(p, q)){
            ans = true;
            return;
        }
        dfs(p.left, q);
        dfs(p.right, q);
    }

    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// @lc code=end

