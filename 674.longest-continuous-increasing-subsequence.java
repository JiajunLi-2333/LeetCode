/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, left = 0, right = 0, n = nums.length;
        while(right < n){
            if(right > 0 && nums[right] <= nums[right - 1]){
                left = right;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
// @lc code=end

