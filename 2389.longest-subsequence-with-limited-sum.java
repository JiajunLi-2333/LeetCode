/*
 * @lc app=leetcode id=2389 lang=java
 *
 * [2389] Longest Subsequence With Limited Sum
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSum =  new int[n + 1];
        for(int i = 0; i < n; i++){
            preSum[i +1] = preSum[i] + nums[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for(int i = 0; i < m;i++){
            int target = queries[i];
            int idx = bSearch(preSum, target);
            ans[i] = idx == -1 ? 0 : idx;
        }
        return ans;
    }
    //return the index of the largest element in the preSum array that is less than or equal to target
    //if no such element exists, return -1
    private int bSearch(int[] preSum, int target){
        int left = -1, right = preSum.length;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(preSum[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        } 
        return left;
    }
}
// @lc code=end

