/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
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
    private final List<Integer> ans = new ArrayList<>();
    private int index = 0;
    private int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        return dfs(root) ? ans : List.of(-1); 
    }
    private boolean dfs(TreeNode root){
        if(root == null) return true;
        if(root.val != voyage[index++]) return false;
        if(root.left != null && root.left.val != voyage[index]){
            ans.add(root.val);
            return dfs(root.right) && dfs(root.left);
        }
        return dfs(root.left) && dfs(root.right);

    }
}
// @lc code=end

