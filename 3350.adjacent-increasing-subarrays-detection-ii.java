/*
 * @lc app=leetcode id=3350 lang=java
 *
 * [3350] Adjacent Increasing Subarrays Detection II
 */

// @lc code=start
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        int cnt = 0, preCnt = 0;
        for(int i = 0; i < n; i++){
            cnt++;
            if(i == n - 1 || nums.get(i) >= nums.get(i + 1)){
                ans = Math.max(ans, Math.max(cnt/2 ,Math.min(preCnt, cnt)));
                preCnt = cnt;
                cnt = 0;
            }

        }
        return ans;
    }
}
// @lc code=end

