/*
 * @lc app=leetcode id=2090 lang=java
 *
 * [2090] K Radius Subarray Averages
 */

// @lc code=start
class Solution {
    //return an integer array
    public int[] getAverages(int[] nums, int k) {
        // int[] result = new int[nums.length];
        // int win_size = 2 * k;
        //! not a logic issue, but a performance issue, the sum of the k elements may be out of the scope of int
        // long sum = 0;
        // //check if the window size is greater than the length of the array
        // if (nums.length < win_size + 1){
        //     for(int i = 0; i < nums.length; i++){
        //         result[i] = -1;
        //     }
        //     return result;
        // }
        // for(int i = 0; i< nums.length; i++){
        //     sum += nums[i];
        //     if (i >= win_size){
        //         result[i-k] = (int)(sum / (win_size + 1));
        //         sum -= nums[i -win_size]; 
        //     }
        // }
        // for(int i = 0; i < k; i++){
        //     result[i] = -1;
        // }
        // for(int i = nums.length - k; i < nums.length; i++){
        //     result[i] = -1;
        // }
        // return result;

        //todo Cleaner Code
        int[] result = new int[nums.length];
        int win_size = 2 * k + 1;
        long sum = 0;
        java.util.Arrays.fill(result, -1);

        if(nums.length < win_size){
            return result;
        }
        if (k == 0){
            return nums;
        }
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(i >= win_size -1){
                result[i - k] = (int)(sum / win_size);
                sum -= nums[i - win_size + 1];
            }
        }
        return result;
    }
}
// @lc code=end

 