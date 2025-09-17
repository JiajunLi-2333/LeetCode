/*
 * @lc app=leetcode id=1793 lang=java
 *
 * [1793] Maximum Score of a Good Subarray
 */

// @lc code=start
class Solution {
    public int maximumScore(int[] nums, int k) {
        //! 哈哈哈 背向双指针 + 贪心本质
        int left = k, right = k;
        int n = nums.length;
        int min = nums[k];
        int ans = min;
        while(left > 0 || right < n - 1){
            if(left == 0){
                right++;
                min = Math.min(min, nums[right]); 
            }
            else if(right == n - 1){
                left--;
                min = Math.min(min, nums[left]);
            }
            else if(nums[left - 1] > nums[right + 1]){
                left--;
                min = Math.min(min, nums[left]); 
            }
            else{
                right++;
                min = Math.min(min, nums[right]); 
            }
            ans = Math.max(ans, min * (right - left + 1));
        }
        return ans;
        
    }
}
// @lc code=end

