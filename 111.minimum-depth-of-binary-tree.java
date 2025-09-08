/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    private int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        minNode(root, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    private void minNode(TreeNode root, int cnt){
        if(root == null) return;
        cnt++;
        if(root.left == null && root.right == null) {
            ans = Math.min(ans, cnt);
            return;
        }
        minNode(root.left, cnt);
        minNode(root.right, cnt);

    }
}
// @lc code=end

