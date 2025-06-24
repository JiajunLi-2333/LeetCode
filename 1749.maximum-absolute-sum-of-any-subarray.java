/*
 * @lc app=leetcode id=1749 lang=java
 *
 * [1749] Maximum Absolute Sum of Any Subarray
 */

// @lc code=start
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        //! time limit exceeded
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // else if (nums.length == 1) {
        //     return Math.abs(nums[0]);
        // }
        // int[] preSum = new int[nums.length + 1];
        // for(int i = 0; i < nums.length; i++){
        //     preSum[i+ 1] = preSum[i] + nums[i];
        // }
        // int ans = 0;
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i ; j < nums.length; j++){
        //         int sum = preSum[j + 1] - preSum[i];
        //         ans = Math.max(ans, Math.abs(sum));
        //     }
        // }
        // return ans;
        int max = 0, min = 0,ans = 0;
        for(int num : nums){
            max = Math.max(max + num, num);
            min = Math.min(min + num, num);
            ans = Math.max(ans, Math.max(Math.abs(max), Math.abs(min)));
        }
        return ans;
    }
}
// @lc code=end

