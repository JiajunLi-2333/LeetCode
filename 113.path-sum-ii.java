/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    private List<List<Integer>> ans = new ArrayList<>();
    private int targetSum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        List<Integer> cur = new ArrayList<>();
        dfs(root, cur, 0);
        return ans; 
    }
    private void dfs(TreeNode root, List<Integer> cur, int sum){
        if(root == null) return;
        cur.add(root.val);
        sum += root.val;
        if(sum == targetSum && root.left == null && root.right == null){
            ans.add(new ArrayList<>(cur));
        }
        dfs(root.left, cur, sum);
        dfs(root.right, cur, sum);
        cur.remove(cur.size() -1);
    }
}
// @lc code=end

