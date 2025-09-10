/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, ans = Integer.MAX_VALUE;
        int sum = 0, cur = 0;
        for(int num : nums) sum += num;
        for(int right = 0; right < nums.length; right++){
            cur += nums[right];
            while(left <= right && sum - cur < x){
                cur -= nums[left++];
            }
            if(sum - cur == x){
                ans = Math.min(ans, nums.length - (right - left + 1));
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

