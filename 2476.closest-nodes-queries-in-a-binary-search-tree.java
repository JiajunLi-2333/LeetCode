/*
 * @lc app=leetcode id=2476 lang=java
 *
 * [2476] Closest Nodes Queries in a Binary Search Tree
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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        
        int n = arr.size();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = arr.get(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int q : queries){
            int j = binary_search(a, q);
            int mx = j == n ? -1 : a[j];
            if(j == n || a[j] != q){
                j--;
            }
            int mn = j < 0 ? -1 : a[j];
            ans.add(List.of(mn, mx));
        }
        return ans;

        
    }
    private void dfs(TreeNode root, List<Integer> arr){
        if(root == null) return;
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr); 
    }
    private int binary_search(int[] a, int target){
        int left = -1, right = a.length;
        while(left + 1 < right){
            int mid = (left + right) >>> 1;
            if(a[mid] >= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }


}
// @lc code=end

