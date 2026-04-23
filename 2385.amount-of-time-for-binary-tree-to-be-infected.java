/*
 * @lc app=leetcode id=2385 lang=java
 *
 * [2385] Amount of Time for Binary Tree to Be Infected
 */
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
    // private int ans;
    // public int amountOfTime(TreeNode root, int start) {
    //     dfs(root, start);
    //     return ans;
    // }

    // private int[] dfs(TreeNode root, int start){
    //     if(root == null) return new int[]{0,0};
    //     int[] left = dfs(root.left, start);
    //     int[] right = dfs(root.right, start);
    //     int leftLen = left[0], leftFound = left[1];
    //     int rightLen = right[0], rightFound = right[1];

    //     if(root.val == start){
    //         //不需要+1因为root本身就已经被感染了
    //         ans = Math.max(leftLen, rightLen);
    //         return new int[]{1,1};
    //     }
    //     if(rightFound == 1 || leftFound == 1){
    //         //只有当左子树或者右子树中有start之后才能更新答案
    //         ans = Math.max(ans, leftLen + rightLen);
    //         return new int[]{(leftFound == 1 ? leftLen : rightLen) + 1, 1};
    //     }
    //     return new int[]{Math.max(leftLen, rightLen) + 1, 0};

    // }
    private int ans = 0;
    public int amountOfTime(TreeNode root, int start){
        dfs(root, start);
        return ans;
    }
    private int[] dfs(TreeNode root, int start){
        if(root == null) return new int[]{0,0};
        int[] left = dfs(root.left, start);
        int[] right = dfs(root.right, start);
        int leftLen = left[0], leftFound = left[1];
        int rightLen = right[0], rightFound = right[1];

        if(root.val == start){
            ans = Math.max(ans, Math.max(leftLen,rightLen));
            return new int[]{1,1};
        }
        if(leftFound == 1 || rightFound == 1){
            ans = Math.max(ans, leftLen + rightLen);
            return new int[]{(leftFound == 1 ? leftLen : rightLen) + 1, 1};
        }
        return new int[]{Math.max(leftLen, rightLen)+ 1,0};

    }
}
// @lc code=end

