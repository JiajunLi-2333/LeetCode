/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */
// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxVal = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++){
            int score = values[i] - i; 
            ans = Math.max(ans, maxVal + score);
            maxVal = Math.max(maxVal, values[i] + i);
        }
        return ans;
    }
}
// @lc code=end

