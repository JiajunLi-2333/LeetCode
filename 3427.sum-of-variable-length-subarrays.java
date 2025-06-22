/*
 * @lc app=leetcode id=3427 lang=java
 *
 * [3427] Sum of Variable Length Subarrays
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            preSum[i +1] = preSum[i] + nums[i];
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int start = Math.max(0, i - nums[i]);
            ans += preSum[i + 1] - preSum[start]; 
        }
        return ans;

    }
}
// @lc code=end

