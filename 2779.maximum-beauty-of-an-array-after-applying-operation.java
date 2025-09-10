/*
 * @lc app=leetcode id=2779 lang=java
 *
 * [2779] Maximum Beauty of an Array After Applying Operation
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, n = nums.length, ans = 1;
        for(int right = 0; right < n; right++){
            while(left < right && nums[right] - nums[left] > 2 * k){
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        } 
        return ans;
    }
}
// @lc code=end

