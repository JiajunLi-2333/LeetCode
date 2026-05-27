/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
import java.util.*;
class Solution {
    int cur = 0, max = 0;
    int prev = Integer.MIN_VALUE;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val == prev) cur++;
        else cur = 1;
        if(cur == max) list.add(root.val);
        else if(cur > max){
            list.clear();
            list.add(root.val);
            max = cur;
        }
        prev = root.val;
        dfs(root.right);

    } 
    
}
// @lc code=end

