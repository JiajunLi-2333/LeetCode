/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = Integer.MAX_VALUE; 
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= target){
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end

