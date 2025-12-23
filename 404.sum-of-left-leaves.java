/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
    
        int ans = dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        if(node.left != null && node.left.left == null && node.left.right == null){
            sum += node.left.val;
        }
        sum += dfs(node.left, 0);
        sum += dfs(node.right, 0);
        return sum;
    }

    
}
// @lc code=end

