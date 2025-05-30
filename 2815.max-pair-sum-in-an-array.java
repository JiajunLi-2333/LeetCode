/*
 * @lc app=leetcode id=2815 lang=java
 *
 * [2815] Max Pair Sum in an Array
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int maxSum(int[] nums) {
        int ans = -1;
        int[] cnt = new int[10];
        Arrays.fill(cnt, Integer.MIN_VALUE);   
        for(int num : nums){
            int d = maxDigit(num);
            ans = Math.max(ans, cnt[d] + num);
            cnt[d] = Math.max(cnt[d], num);
        }
        return ans;
    }
    private int maxDigit(int n){
        int max = 0;
        int x = n;
        while(x > 0){
            max = Math.max(max, x % 10);
            x /= 10;
        }
        return max;
    }
}
// @lc code=end

