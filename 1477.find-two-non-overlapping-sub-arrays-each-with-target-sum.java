/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        //todo approach One: two pointers need two for loops
        //! remeber the information using an array
        // int n = arr.length, pre = Integer.MAX_VALUE / 2, ans = Integer.MAX_VALUE, sum = 0;
        // int[] suf = new int[n + 1];
        // int right = n -1, left = 0;
        // Arrays.fill(suf, Integer.MAX_VALUE / 2);// fill the suffix array with max value
        // for(int l = n -1; l > 0; l--){
        //     sum += arr[l];
        //     while(sum > target){
        //         sum -= arr[right--];
        //     }
        //     if(sum == target){
        //         suf[l] = Math.min(suf[l + 1], right - l + 1);
        //     }
        //     else{
        //         suf[l] = suf[l + 1];
        //     }
        // }
        // sum = 0;
        // for(int r = 0; r < n; r++){
        //     sum += arr[r];
        //     while(sum > target){
        //         sum -= arr[left++];
        //     }
        //     if(sum == target){
        //         pre = Math.min(pre, r - left + 1);
        //     }
        //     if(r + 1 < n){
        //         ans = Math.min(ans, pre + suf[r + 1]);
        //     }
        // }
        // return ans >= Integer.MAX_VALUE/2 ? -1 : ans;

        //todo approach: HashMap and prefix sum
        
    }
}
// @lc code=end

