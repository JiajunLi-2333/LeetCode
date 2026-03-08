/*
 * @lc app=leetcode id=2096 lang=java
 *
 * [2096] Step-By-Step Directions From a Binary Tree Node to Another
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = LCA(root, startValue, destValue);
        StringBuilder sbStart = new StringBuilder();
        StringBuilder sbDest = new StringBuilder();
        find(ancestor, startValue, sbStart);
        find(ancestor, destValue, sbDest);
        
        String toStart = "U".repeat(sbStart.length());
        String toDest = sbDest.toString();
        return toStart + toDest;

    }
    private TreeNode LCA(TreeNode root, int start, int dest){
        if(root == null || root.val == start || root.val == dest){
            return root;
        }
        TreeNode left = LCA(root.left, start, dest);
        TreeNode right = LCA(root.right, start, dest);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left; 
        }
        return right;
    }

    private boolean find(TreeNode root, int val, StringBuilder sb){
        if (root == null) return false;
        if(root.val == val) return true;
        
        sb.append('L');
        if(find(root.left, val, sb)) return true;
        sb.deleteCharAt(sb.length() -1);//回溯操作

        sb.append('R');
        if(find(root.right,val,sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}
// @lc code=end

