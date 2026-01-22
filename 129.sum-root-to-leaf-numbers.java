/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    int ans = 0;
    int path = 0;
    public int sumNumbers(TreeNode root) {
        // int ans = helper(root, 0);
        // return ans;
        dfs(root);
        return ans;
    }

    //采取先序遍历
    public void dfs(TreeNode root){
        if(root == null) return;
        path = path * 10 + root.val;
        if(root.left == null && root.right == null){
            ans += path;
        }
        dfs(root.left);
        dfs(root.right);
        //回溯
        path = (path - root.val) / 10;
    }

    //分解子问题 ： 原问题 = 左树之和 + 右树之和
    //val 代表截至当前节点的累积值 记录temporary state
//     public int helper(TreeNode root, int val){
//         if(root == null) return 0;
//         val = val * 10 + root.val;
//         if(root.left == null && root.right == null) return val;
//         return helper(root.left, val) + helper(root.right, val);
//     }
// }
}
// @lc code=end

