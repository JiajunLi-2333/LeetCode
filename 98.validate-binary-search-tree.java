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
    // Integer prev = null;  // 用 Integer + null 比 MIN_VALUE 哨兵更稳
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        // return dfs(root);
        // dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);//trick here: use long to avoid overflow
        // return ans;

        dfs(root);
        return ans;
    }
    // private boolean dfs(TreeNode root) {
    //     if (root == null) return true;
    //     if (!dfs(root.left)) return false;
    //     if (prev != null && root.val <= prev) return false;
    //     prev = root.val;
    //     return dfs(root.right);
    // }

    //! pre-order version
    // private void dfs(TreeNode root, long min, long max){
    //     if(root == null) return;
    //     if(root.val <= min || root.val >= max){
    //         ans = false;
    //         return;
    //     }
    //     dfs(root.left, min, root.val);
    //     dfs(root.right, root.val, max);
    // } 
    //! post-order version
    //long[子树中的最小值，子树中的最大值]
    private long[] dfs(TreeNode root){
        if(root == null) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        long val = root.val;
        if(val <= left[1] || val >= right[0]){
            ans =false;
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(val, left[0]), Math.max(val, right[1])};
    }
}
// @lc code=end

