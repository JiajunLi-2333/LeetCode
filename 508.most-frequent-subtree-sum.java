/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        dfs(root, count);
        int maxFreq = 0;
        for(int freq : count.values()) maxFreq = Math.max(maxFreq, freq);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            if(e.getValue() == maxFreq) res.add(e.getKey());
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }

    private int dfs(TreeNode node, Map<Integer, Integer> count){
        if(node == null) return 0;
        int sum = node.val + dfs(node.left, count) + dfs(node.right, count);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
// @lc code=end

