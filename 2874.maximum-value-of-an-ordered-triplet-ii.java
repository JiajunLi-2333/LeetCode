/*
 * @lc app=leetcode id=2874 lang=java
 *
 * [2874] Maximum Value of an Ordered Triplet II
 */

// @lc code=start
class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0; 
        int maxDiff = 0;
        int max = 0;
        for (int num : nums){
            ans  = Math.max(ans, (long)maxDiff * num);
            maxDiff = Math.max(maxDiff, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}
// @lc code=end

