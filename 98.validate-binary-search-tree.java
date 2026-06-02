/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
       dfs(root);
       return ans;
    }
    //[the min of the subtree, the max of the subtree]
    private long[] dfs(TreeNode root){
        if(root == null) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        long val = root.val;
        if(val <= left[1] || val >= right[0]){
            ans = false;
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        } 
        return new long[]{Math.min(val, left[0]), Math.max(val, right[1])};
    }

    
    
    
}
// @lc code=end

