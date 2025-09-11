/*
 * @lc app=leetcode id=2760 lang=java
 *
 * [2760] Longest Even Odd Subarray With Threshold
 */

// @lc code=start
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0, left = 0;
        while(left < n){
            if(nums[left] > threshold || nums[left] % 2  == 1){
                left++;
                continue;
            }
            int right = left + 1;
            while(right < n && nums[right] <= threshold && nums[right] % 2 != nums[right - 1] % 2){
                right++;
            }
            ans = Math.max(ans, right - left);
            // move the left pointer to right
            left = right;
        }
        return ans;
    }
}
// @lc code=end

