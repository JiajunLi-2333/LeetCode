/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
       int n = nums.length;
       int[] s = new int[n+1];
       for(int i = 0; i < n; i++){
        s[i + 1] = s[i] + nums[i];
       }
       return Math.max(func(s,firstLen,secondLen), func(s,secondLen,firstLen));


    }
    private int func(int[] prefixSum, int firstLen, int secondLen){
        int ans = 0, max = 0; 
        for(int i = firstLen + secondLen; i < prefixSum.length; i++){
            max = Math.max(max,prefixSum[i - secondLen] - prefixSum[i - secondLen - firstLen]);
            ans = Math.max(ans, max + prefixSum[i] - prefixSum[i - secondLen]);
        }
        return ans;
    }
   
}
// @lc code=end

