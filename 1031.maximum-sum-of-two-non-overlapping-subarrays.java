/*
 * @lc app=leetcode id=1031 lang=java
 *
 * [1031] Maximum Sum of Two Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //! I managed to crack out the logic of using iterate the right pointer and maintain the left to reduce the number of changing variables but I failed to think of using the prefix sum to reduce the time complexity.
        int n = nums.length;
        int prefixSum[] =  new int[n + 1];
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return Math.max(getMaxSum(prefixSum, firstLen, secondLen), getMaxSum(prefixSum, secondLen, firstLen));


    }
    private int getMaxSum(int[] prefixSum, int firstLen, int secondLen){
        int n = prefixSum.length;
        int maxSumFirst = 0, ans = 0;
        for(int i = firstLen + secondLen; i < n; i++){
            maxSumFirst = Math.max(maxSumFirst, prefixSum[i -secondLen] - prefixSum[i - firstLen - secondLen]);
            ans = Math.max(ans, maxSumFirst + prefixSum[i] - prefixSum[i - secondLen]);
        }
        return ans;
    }
}
// @lc code=end

