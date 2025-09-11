/*
 * @lc app=leetcode id=2348 lang=java
 *
 * [2348] Number of Zero-Filled Subarrays
 */

// @lc code=start
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length; 
        long ans = 0;
        while(right < n){
            if(nums[right] == 0){
                right++;
            }
            else{
                int len = right - left;
                ans += (long)len * (len + 1) / 2;
                right++;
                left = right;
            }
        }
        //处理最后一个窗口的情况
        int len = right - left;
        ans += (long)len * (len + 1) / 2;
        return ans;
    }
}
// @lc code=end

