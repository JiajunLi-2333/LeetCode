/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = 0;
        for(Integer key: map.keySet()){
            max = Math.max(max, map.get(key));
        }  
        List<Integer> list = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        if(map.containsKey(root.val)){
            map.merge(root.val, 1,Integer::sum);
        }
        else{
            map.put(root.val, 1);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
// @lc code=end

