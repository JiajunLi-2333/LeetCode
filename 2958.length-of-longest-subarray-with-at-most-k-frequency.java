/*
 * @lc app=leetcode id=2958 lang=java
 *
 * [2958] Length of Longest Subarray With at Most K Frequency
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, ans = 0, n = nums.length;
        for(int right = 0; right < n; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.get(nums[right]) > k){
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }
}
// @lc code=end

