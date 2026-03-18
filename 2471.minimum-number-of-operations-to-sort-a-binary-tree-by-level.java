/*
 * @lc app=leetcode id=2471 lang=java
 *
 * [2471] Minimum Number of Operations to Sort a Binary Tree by Level
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;

        while(!queue.isEmpty()){
            int n = queue.size(); 
            List<Integer> list = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans += minSwaps(list);
        }
        return ans;
    }
    private int minSwaps(List<Integer> vals){
        int n = vals.size();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = vals.get(i);
        }

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        int swap = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != sorted[i]){
                int index = map.get(sorted[i]);
                map.put(arr[i], index);
                map.put(arr[index], i);
                int tmp = arr[i]; arr[i] = arr[index];arr[index] = tmp;
                swap++;
            }
        }
        return swap;
    }
}
// @lc code=end

