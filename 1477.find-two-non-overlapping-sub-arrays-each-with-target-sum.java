/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        //! feels very dynamic programming

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
        int n = arr.length, ans = Integer.MAX_VALUE;
        int[] preSum = new int[n + 1];
        int[] min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i = 1; i <=n; i++){
            int x = preSum[i];
            if(map.containsKey(x - target)){
                int begin = map.get(x - target);
                int len = i - begin;
                if(begin > 0 && min[begin] != Integer.MAX_VALUE){
                    ans = Math.min(ans, len + min[begin]);
                }
                min[i] = Math.min(min[i - 1], len);
            } else {
                min[i] = min[i - 1];
            }
            map.put(x, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

