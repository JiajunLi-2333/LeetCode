/*
 * @lc app=leetcode id=1838 lang=java
 *
 * [1838] Frequency of the Most Frequent Element
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, ans = 0, n = nums.length;
        long total = 0; 
        for(int right = 0; right < n; right++){
            total += nums[right];
            while((long) nums[right] * (right - left + 1) - total > k){
                total -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    
    }
}
// @lc code=end

