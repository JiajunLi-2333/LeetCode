/*
 * @lc app=leetcode id=3152 lang=java
 *
 * [3152] Special Array II
 */

// @lc code=start
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] ans = new boolean[queries.length];
        int[] preSum = new int[n + 1];
        for(int i = 0; i < n -1; i++){
            int cur = nums[i];
            int nxt = nums[i + 1];
            if((cur  % 2 == 0 && nxt % 2 == 1) || (cur % 2 == 1 && nxt % 2 == 0)){
                preSum[i + 1] = preSum[i] + 1;
            } else {
                preSum[i + 1] = preSum[i];
            }
        }
        for(int i = 0; i < queries.length; i++){
            int diff = queries[i][1] - queries[i][0];
            int count = preSum[queries[i][1]] - preSum[queries[i][0]];
            ans[i] = count == diff;
        }
        return ans;
        
    }
}
// @lc code=end

