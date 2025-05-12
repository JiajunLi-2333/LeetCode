/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {;
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(i >= k - 1){
                max = Math.max(max, sum/k);
                sum -= nums[i-k+ 1];
            }
        }
        return max;
    }
}
// @lc code=end

