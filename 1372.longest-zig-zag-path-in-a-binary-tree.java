/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
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
    // private int ans = 0; 
    //TODO 
    private int ans = 0; 
    public int longestZigZag(TreeNode root) {
        // dfs(root, true, 0);
        // return ans;
        dfs(root);
        return ans;
    }
    // private void dfs(TreeNode root, Boolean direct, int len){
    //     if(root == null) return;
    //     ans = Math.max(ans, len);
    //     if(direct){//true means this node is the left child of its parent node
    //         dfs(root.left, true, 1);
    //         dfs(root.right, false, len + 1); 
    //     }
    //     else{
    //         dfs(root.left, true, len + 1);
    //         dfs(root.right, false, 1);
    //     }
    // }

    //TODO dfs from bottom to top
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{-1,-1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int leftLen = left[1] + 1;
        int rightLen = right[0] + 1;
        ans = Math.max(ans, Math.max(leftLen, rightLen));
        return new int[]{leftLen, rightLen};
    }

    
}
// @lc code=end

