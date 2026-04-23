/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */
import java.util.*;
class Solution {
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;

    }
    private int dfs(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return 0; 
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int sum = left + right + root.val;
        map.merge(sum,1,Integer::sum);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
// @lc code=end

