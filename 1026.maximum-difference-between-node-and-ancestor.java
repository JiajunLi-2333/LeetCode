/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
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
    private int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        //post-order
        // dfs(root);
        // return ans;
        dfs(root, root.val, root.val);
        return ans;
    }

    //后序遍历
    // private int[] dfs(TreeNode root){
    //     if(root == null){
    //         return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
    //     }
    //     int[] left = dfs(root.left);
    //     int[] right = dfs(root.right);
    //     int val = root.val;
    //     int min = Math.min(val,Math.min(left[0], right[0]));
    //     int max = Math.max(val,Math.max(left[1], right[1]));
    //     ans = Math.max(ans,Math.max(Math.abs(val - min),Math.abs(max - val)));
    //     return new int[]{Math.min(min,val), Math.max(max, val)};
    // }

    //先序遍历
    private void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        int val = root.val;
        ans = Math.max(ans, Math.max((val - min), (max- val)));
        dfs(root.left, Math.min(min, val), Math.max(max, val));
        dfs(root.right, Math.min(min, val), Math.max(max, val));
    }

    
}
// @lc code=end

