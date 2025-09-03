/*
 * @lc app=leetcode id=2962 lang=java
 *
 * [2962] Count Subarrays Where Max Element Appears at Least K Times
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = 0;
        for(int num: nums){
            mx = Math.max(mx, num);
        }

        long ans = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == mx){
                k--;
            }
            while(k == 0){
                if(nums[left] == mx){
                    k++;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end

