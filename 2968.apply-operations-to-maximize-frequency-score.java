/*
 * @lc app=leetcode id=2968 lang=java
 *
 * [2968] Apply Operations to Maximize Frequency Score
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        //Sliding window (unfixed length) to prunate 
        // array in order helps to solve the problem
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int left = 0, ans = 0;
        for(int i = 0; i < nums.length; i++){
            while(moveSum(prefixSum, nums, left, (left + i) / 2, i) > k){
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }


    //use prefixSum to quickly find out the number of operations needed

    //medium number Greedy thinking
    public long moveSum(long[] prefixSum, int[] nums, int left, int i, int right){
        long l = (long)nums[i] * (i - left) - (prefixSum[i] - prefixSum[left]);
        long r = (prefixSum[right + 1] - prefixSum[i + 1]) - (long) nums[i] * (right - i);
        return l + r;
    }
}
// @lc code=end

