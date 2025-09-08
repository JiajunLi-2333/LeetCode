/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        //使用层序遍历的方式
        // List<Integer> ans = new ArrayList<>(); 
        // if(root == null) return ans;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     for(int i = 0; i < size; i++){
        //         TreeNode node = queue.poll();
        //         if(i == size - 1) ans.add(node.val);
        //         if(node.left != null) queue.offer(node.left);
        //         if(node.right != null) queue.offer(node.right);
        //     }
        // }
        // return ans; 
        //! 思考递归做法：先遍历右子树，再遍历左子树
        //! 先思考左右两棵树之间的关系 再思考递归的细节 
        //! 递归的条件是原问题能够分解成相似的子问题
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    private void dfs(TreeNode node, int depth, List<Integer> ans){
        if(node == null) return;
        if(depth == ans.size()) ans.add(node.val);
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }
}
// @lc code=end

