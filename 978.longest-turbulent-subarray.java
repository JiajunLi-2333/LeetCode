/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 0, n = arr.length;
        int left = 0;
        for(int right = 1; right < n; right++){
            int c = Integer.compare(arr[right - 1], arr[right]);
            if(c == 0){
                left = right;
            } else if(right == n - 1 || c * Integer.compare(arr[right], arr[right + 1]) != -1){

                //! c * Integer.compare(arr[right], arr[right + 1]) != -1 excluded the case of same signs
                ans = Math.max(ans, right - left + 1);
                left = right;
            }
        }
        return Math.max(ans, n - left);
    }
}
// @lc code=end

