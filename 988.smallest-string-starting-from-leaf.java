/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
    StringBuilder ans = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans.toString();
    }
    private void dfs(TreeNode node, StringBuilder cur){
        if(node == null) return;
        cur.append((char) ('a' + node.val));
        if(node.left == null && node.right == null){
            cur.reverse();
            if(ans.length() == 0 || cur.toString().compareTo(ans.toString()) < 0){
                ans = new StringBuilder(cur);
            }
            cur.reverse();
        }
        dfs(node.left, cur);
        dfs(node.right, cur);
        cur.deleteCharAt(cur.length() - 1);
    }
}
// @lc code=end

