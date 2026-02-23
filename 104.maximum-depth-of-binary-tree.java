/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    int ans = -1;
    int curDepth = 0;// the depth of the current node
    public int maxDepth(TreeNode root) {
        // if(root == null){
        //     return 0;
        // }
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return Math.max(left, right) + 1;
        if(root == null) return 0;
        dfs(root);
        return ans;


    }
    public void dfs(TreeNode root){
        if (root == null) return;
        curDepth += 1;
        if(root.left == null && root.right == null){
            ans = Math.max(ans, curDepth);
        } 

        dfs(root.left);
        dfs(root.right);
        curDepth -= 1;
    }
}
// @lc code=end

