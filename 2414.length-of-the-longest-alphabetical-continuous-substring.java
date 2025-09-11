/*
 * @lc app=leetcode id=2414 lang=java
 *
 * [2414] Length of the Longest Alphabetical Continuous Substring
 */

// @lc code=start
class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int left = 0;
        int n = s.length();
        for(int right = 0; right < n; right++){
            if(right > 0 && s.charAt(right) - s.charAt(right - 1) != 1){
                left = right;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

