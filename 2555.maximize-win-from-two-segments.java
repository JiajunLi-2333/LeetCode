/*
 * @lc app=leetcode id=2555 lang=java
 *
 * [2555] Maximize Win From Two Segments
 */

// @lc code=start
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int ans = 0, n = prizePositions.length, left = 0;
        int[] mx = new int[n + 1 ];
        if (2 * k + 1 >= prizePositions[n - 1] - prizePositions[0]) {
            return n;
        }
        for(int right = 0; right < n; right++){
            while(prizePositions[right] - prizePositions[left] > k){
                left++;
            }
            ans = Math.max(ans, mx[left] + right - left + 1);
            mx[right + 1] = Math.max(mx[right], right - left + 1);
        }
        return ans; 
    }
}
// @lc code=end

