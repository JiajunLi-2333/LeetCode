/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
import java.util.*;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        //算法思想：二叉树遍历 + 递归
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    private void postorder(TreeNode root, List<Integer> ans){
        //递归终止条件
        if(root == null) return;

        //递归顺序
        postorder(root.left, ans);
        postorder(root.right, ans);
        //节点处理时间和维护操作
        ans.add(root.val);
    }
}
// @lc code=end

