/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int level = 0;
        int ans = 0;
        if(root.left == null && root.right == null) return root.val;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            int sum = 0;
            level++;
            while(n-- > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(sum > max){
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
// @lc code=end

