/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParentMap(root, null);//?根节点映射
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);
        int dist = 0;
        while(!queue.isEmpty()){
            if(dist == k){
                List<Integer> ans = new ArrayList<>();
                for(TreeNode node : queue){
                    ans.add(node.val);
                }
                return ans;
            }
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                for(TreeNode next : new TreeNode[]{node.left, node.right, map.get(node)}){
                    if(next != null && !visited.contains(next)){
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            dist++;
            
        }
        return new ArrayList<>();
    }
    private void buildParentMap(TreeNode node, TreeNode parent){
        if(node == null) return;
        map.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
// @lc code=end

