/*
 * @lc app=leetcode id=3105 lang=java
 *
 * [3105] Longest Strictly Increasing or Strictly Decreasing Subarray
 */

// @lc code=start
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length,i = 0;
        int ans = 1;
        while(i < n -1){
            if(nums[i] == nums[i + 1]){
                i++;
                continue;
            }
            int left = i;
            boolean isInc = nums[i] < nums[i + 1];
            i += 2;
            while(i < n && nums[i] != nums[i - 1] && (nums[i] > nums[i - 1]) == isInc){
                i++;
            }
            ans = Math.max(ans, i - left);
            i--;
        }
        return ans;
    }
}
// @lc code=end

