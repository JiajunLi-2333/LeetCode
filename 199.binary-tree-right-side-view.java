/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */
import java.util.*;
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
    int depth = 0;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode node){
        if(node == null) return;
        //first time reach this depth
        //the next two lines cannot be swapped
        if(depth == ans.size()) ans.add(node.val);
        depth++;
        helper(node.right);
        helper(node.left);
        depth--;
    }
    
}
// @lc code=end

