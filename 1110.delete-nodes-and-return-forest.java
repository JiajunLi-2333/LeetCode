/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start

import java.util.*; 

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
    private List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : to_delete) {
            set.add(x);
        }
        TreeNode res = dfs(root, set);
        if (res != null) {
            ans.add(res);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode root, HashSet<Integer> set) {
        if (root == null) return null;
        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);

        if (set.contains(root.val)) {
            if (left != null) ans.add(left);
            if (right != null) ans.add(right);
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end

