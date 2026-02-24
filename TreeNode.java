/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int curDepth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode dummy = new TreeNode(0, root, null);
        dfs(dummy, val, depth);
        return dummy.left;
    }

    private void dfs(TreeNode root, int val, int depth){
        if(root == null) return; 
        curDepth++;
        if(curDepth == depth){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }
        dfs(root.left, val, depth);
        dfs(root.right, val, depth);
        curDepth--;
    }
}
// @lc code=end

