/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    // int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
        
        // dfs(root, new ArrayList<>());
        // return ans;
    }
    // private void dfs(TreeNode root, List<Integer> list){
    //     if(root == null) return;
    //     list.add(root.val);
    //     //when leaf node
    //     if(root.left == null && root.right == null){
    //         ans += Convert(list);
    //     } 
    //     dfs(root.left, list);
    //     dfs(root.right, list);
    //     list.remove(list.size() -1);
    // }
    // private int Convert(List<Integer> list){
    //     int ans = 0;
    //     int len = list.size();
    //     for(int i = 0; i < len; i++){
    //         ans = ans*2 + list.get(i);
    //     }
    //     return ans;
    // }


    //! second dfs: decompose the problem into subproblems
    private int dfs(TreeNode root, int num){
        if(root == null) return 0;
        num = num << 1 | root.val;
        if(root.left == null && root.right == null){
            return num;
        }

        return dfs(root.left, num) + dfs(root.right, num);
    }
}
// @lc code=end

