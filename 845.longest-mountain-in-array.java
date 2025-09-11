/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;

        int left = -1, ans = 0; 
        for(int right = 1; right < n; right++){
            if(arr[right] > arr[right -1]){
                // start of a new mountain
                if(right == 1 || arr[right -1] <= arr[right - 2]) left = right - 1;
            }
            else if(arr[right] < arr[right - 1]){
                if(left != -1){
                    // end of a mountain
                    ans = Math.max(ans, right - left + 1);
                }
            }
            else{
                left = -1;
            }

        }
        return ans;
        
    }
}
// @lc code=end

