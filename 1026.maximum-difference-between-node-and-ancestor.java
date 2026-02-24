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
    // private int maxDiff = Integer.MIN_VALUE;
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        // dfs(root, root.val, root.val);
        // return maxDiff;
        dfs(root);
        return ans;
    }
    // private void dfs(TreeNode node, int curMax, int curMin){
    //     if(node == null) return;
    //     curMax = Math.max(curMax, node.val);
    //     curMin = Math.min(curMin, node.val);
    //     maxDiff = Math.max(maxDiff, curMax - curMin);
    //     dfs(node.left, curMax, curMin);
    //     dfs(node.right, curMax, curMin);
    // }

    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int min = Math.min(root.val, Math.min(left[0], right[0]));
        int max = Math.max(root.val, Math.max(left[1], right[1]));

        ans = Math.max(ans, Math.max(root.val - min, max - root.val));
        return new int[]{min, max};

    }


}
// @lc code=end

