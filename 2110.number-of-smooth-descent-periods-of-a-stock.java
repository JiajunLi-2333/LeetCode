/*
 * @lc app=leetcode id=2110 lang=java
 *
 * [2110] Number of Smooth Descent Periods of a Stock
 */

// @lc code=start
class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int n = prices.length, left  = 0;
        for(int right = 0; right < n; right++){
            if(right > 0  && prices[right -1] != prices[right] + 1){
                int len = right - left;
                //! cast to long to avoid overflow
                ans += (long) len * (len + 1) / 2;
                left = right;
            }
        }
        //handle the last segment
        return ans + (long)(n - left) * (n - left + 1) / 2;
    }
}
// @lc code=end

