/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        //the root node is symmetric by itself
        //for the nodeLeft.left == nodeRight.right && nodeLeft.right == nodeRight.left
        return same(root.left, root.right);
        
    }

    public boolean same(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        boolean left = same(p.left, q.right);
        boolean right = same(p.right, q.left);

        return p.val == q.val && left && right;
    }
}
// @lc code=end

