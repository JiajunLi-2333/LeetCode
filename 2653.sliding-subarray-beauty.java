/*
 * @lc app=leetcode id=2653 lang=java
 *
 * [2653] Sliding Subarray Beauty
 */

// @lc code=start
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        //use counting sort to count the number of elements in the current window
        int[] counter = new int[50];
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < k -1; i++){
            if(nums[i] < 0){//care only about the negative numbers
                counter[nums[i] + 50]++;
            }
        }
        for(int i = k -1; i < nums.length; i++){
            if(nums[i] < 0){
                counter[nums[i]+50]++;
            }
            int count = x;
            for(int j = 0; j < counter.length; j++){
                count -= counter[j];
                if(count <= 0){
                    result[i - k + 1] = j - 50;
                    break;
                }
            }
            if(nums[i - k + 1] < 0){
                counter[nums[i - k + 1] + 50]--;
            }
        }
        return result;

    }
}
// @lc code=end

