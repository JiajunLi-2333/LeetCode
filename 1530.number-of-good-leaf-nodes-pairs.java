/*
 * @lc app=leetcode id=1530 lang=java
 *
 * [1530] Number of Good Leaf Nodes Pairs
 */
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
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans; 
    }

    private int[] dfs(TreeNode root, int distance){
        int[] arr = new int[distance + 1];
        if(root == null) return arr;
        if(root.left == null && root.right == null){
            arr[0] = 1;
            return arr;
        }
        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);
        for(int i = 0; i < distance; i++){
            for(int j = 0; j < distance; j++){
                if(i + j + 2 <= distance){
                    ans += left[i] * right[j];
                } 
            }
        }
        for(int d = 0; d < distance; d++){
            arr[d+1] = left[d] + right[d]; 
        }
        return arr;
    }    
    
}
// @lc code=end

