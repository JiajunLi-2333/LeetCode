/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    // Set<Integer> set = new HashSet<>();
    // public int findSecondMinimumValue(TreeNode root) {
    //     dfs(root);
    //     if(set.size() < 2){
    //         return -1;
    //     }
    //     int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    //     for(int i : set){
    //         if(i <= first){
    //             second = first;
    //             first = i;
    //         }
    //         else if(i <= second){
    //             second = i;
    //         }
    //     }
    //     return second;
        
    // }
    // public void dfs(TreeNode node){
    //     if(node == null) return;
    //     set.add(node.val);
    //     dfs(node.left);
    //     dfs(node.right);
    // }

    int ans = -1; 
    public int findSecondMinimumValue(TreeNode root){
        //use the property that root.val = min(root.left.val, root.right.val)
        dfs(root, root.val);
        return ans;
    }
    public void dfs(TreeNode root, int cur){
        if(root == null) return;
        if(root.val != cur){
            if(ans == -1) ans = root.val;
            else ans = Math.min(root.val, ans);
            return; // early return
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
    
}
// @lc code=end

