/*
 * @lc app=leetcode id=3381 lang=java
 *
 * [3381] Maximum Subarray Sum With Length Divisible by K
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        long[] preSum = new long[n + 1];
        for(int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + nums[i];
        long[] mins = new long[k];
        Arrays.fill(mins, Long.MAX_VALUE /2); //prevent addtion overflow
        for(int i = 0; i < preSum.length; i++){
            int index = i % k;
            ans = Math.max(ans, preSum[i] - mins[index]);
            mins[index] = Math.min(mins[index], preSum[i]);
        }
        return ans;
    }
}
// @lc code=end

