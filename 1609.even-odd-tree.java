/*
 * @lc app=leetcode id=1609 lang=java
 *
 * [1609] Even Odd Tree
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
    List<Integer> lastVal = new ArrayList<>();
    public boolean isEvenOddTree(TreeNode root) {
        return dfs(root, 0);
    }
    private boolean dfs(TreeNode root, int level){
        if(root == null) return true;
        int val = root.val;
        if(level % 2 == 0 && val % 2 == 0) return false;
        if(level % 2 == 1 && val % 2 == 1) return false;
        
        if(level < lastVal.size()){//? this means that we already have previous values;
            int prev = lastVal.get(level);
            if(level % 2 == 0 && val <= prev) return false; 
            if(level % 2 == 1 && val >= prev) return false; 
            lastVal.set(level, val);
        }else{
            lastVal.add(val);
        }
        return dfs(root.left, level + 1) && dfs(root.right, level + 1);

    }
}
// @lc code=end

