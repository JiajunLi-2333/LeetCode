/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }
    private TreeNode recursion(int[] nums, int low, int high){
        if(low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, low, mid -1);
        root.right = recursion(nums, mid + 1, high);
        return root;

    }
}
// @lc code=end

