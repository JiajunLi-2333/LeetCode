/*
 * @lc app=leetcode id=1932 lang=java
 *
 * [1932] Merge BSTs to Create Single BST
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
    private HashSet<Integer> leaves = new HashSet<>();
    private Map<Integer, TreeNode> map = new HashMap<>(); //All BST given has different root node value
    private boolean isBST = true;// indicator of whether the final concatenated tree is BST or not
    public TreeNode canMerge(List<TreeNode> trees) {
        // The answer is actually unique
        for(TreeNode tree : trees){
            if(tree.left != null){
                leaves.add(tree.left.val);
            }
            if(tree.right != null){
                leaves.add(tree.right.val);
            }
            map.put(tree.val, tree);
        }

        for(TreeNode tree : trees){
            if(!leaves.contains(tree.val)){
                map.remove(tree.val);

                dfs(tree, Integer.MIN_VALUE);
                return isBST && map.isEmpty() ? tree : null;
            }
        }
        return null;
    }
    private int dfs(TreeNode node, int prev){
        if(node == null) return prev;
        if(node.left == null && node.right == null && map.containsKey(node.val)){
            node.left = map.get(node.val).left;
            node.right = map.get(node.val).right;
            map.remove(node.val);
        }
        int left = dfs(node.left, prev);
        if(node.val <= left){
            isBST = false;
        }
        return dfs(node.right, node.val);

    }
}
// @lc code=end

