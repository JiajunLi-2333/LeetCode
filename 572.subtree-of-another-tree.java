/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    private int height = 0;
    private boolean found = false;
    private TreeNode subRoot;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        getHeight(subRoot,0);
        this.subRoot = subRoot;
        dfs(root);
        return found;


    }
    private int dfs(TreeNode root){
        if(root == null || found) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
        if(curHeight == height && isSameTree(root, subRoot)){
            found = true;
        }
        return curHeight; 
    } 

    private void getHeight(TreeNode root,int Height){
        if(root == null){
            height = Math.max(height, Height);
            return;
        }
        getHeight(root.left, Height +1);
        getHeight(root.right, Height + 1);
    }
    private boolean isSameTree(TreeNode nodeOne, TreeNode nodeTwo){
        if(nodeOne == null && nodeTwo == null) return true;
        if(nodeOne == null || nodeTwo == null) return false;
        if(nodeOne.val != nodeTwo.val)return false;
        return isSameTree(nodeOne.left, nodeTwo.left) && isSameTree(nodeOne.right, nodeTwo.right); 
    }
}
// @lc code=end

