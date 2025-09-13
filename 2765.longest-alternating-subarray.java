/*
 * @lc app=leetcode id=2765 lang=java
 *
 * [2765] Longest Alternating Subarray
 */

// @lc code=start
class Solution {
    public int alternatingSubarray(int[] nums) {
        int ans = -1, n = nums.length;
        int right = 0;
        while(right < n -1){
            if(nums[right + 1] - nums[right] != 1){
                right++;
                continue;
            }
            int left = right;
            right += 2;
            while(right < n && nums[right] == nums[right - 2]){
                right++;
            }
            ans = Math.max(ans, right - left);
            right--;

        }
        return ans;
    }
}
// @lc code=end

