/*
 * @lc app=leetcode id=2134 lang=java
 *
 * [2134] Minimum Swaps to Group All 1's Together II
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] nums) {
        int winSize = 0;
        int ans = 0;
        int n = nums.length;
        int Ones = 0;
        for(int i = 0; i < nums.length; i++) {
            winSize += nums[i];
        }

        for(int i = 0; i < winSize; i++){
            Ones += nums[i];
        }
        ans = Ones;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, Ones);
            Ones -= nums[i];
            Ones += nums[(i + winSize) % n];
        }
        return winSize - ans;
        
    }
}
// @lc code=end

