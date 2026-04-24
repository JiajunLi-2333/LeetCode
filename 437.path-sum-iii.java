/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root,0, targetSum, map);
        return ans; 
    }
    private void dfs(TreeNode root, long sum, int targetSum, Map<Long, Integer> map){
        if(root == null) return;
        sum += root.val;
        ans += map.getOrDefault(sum - targetSum, 0);
        map.merge(sum, 1, Integer::sum);
        dfs(root.left, sum, targetSum, map);
        dfs(root.right, sum, targetSum, map);
        map.merge(sum, -1, Integer::sum);
    }
}
// @lc code=end

