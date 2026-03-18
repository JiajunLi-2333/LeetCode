/*
 * @lc app=leetcode id=2641 lang=java
 *
 * [2641] Cousins in Binary Tree II
 */

// @lc code=start

import java.util.ArrayDeque;

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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            int nextLevelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node.left != null) { queue.add(node.left); nextLevelSum += node.left.val; }
                if (node.right != null) { queue.add(node.right); nextLevelSum += node.right.val; }
            }
            for (TreeNode node : level) {
                int childrenSum = (node.left != null ? node.left.val : 0)
                                + (node.right != null ? node.right.val : 0);
                if (node.left != null) node.left.val = nextLevelSum - childrenSum;
                if (node.right != null) node.right.val = nextLevelSum - childrenSum;
            }
        }
        return root;
    }
}
// @lc code=end

