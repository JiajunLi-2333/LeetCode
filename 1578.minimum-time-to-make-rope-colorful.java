/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Time to Make Rope Colorful
 */
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, minTime = neededTime[0];
        int n = colors.length();
        for(int i = 1; i < n; i++){
            if(colors.charAt(i) != colors.charAt(i - 1)){
                minTime = neededTime[i];
            }
            else{
                ans += Math.min(minTime, neededTime[i]);
                minTime = Math.max(minTime, neededTime[i]);
            }

        }
        return ans;
        
        
    }
}
// @lc code=end

