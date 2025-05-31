/*
 * @lc app=leetcode id=2905 lang=java
 *
 * [2905] Find Indices With Index and Value Difference II
 */

// @lc code=start
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIndex = 0, minIndex = 0;
        for (int j = indexDifference; j < nums.length; j++){
            int i = j - indexDifference;
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            int maxDiff = Math.abs(nums[maxIndex] - nums[j]);
            int minDiff = Math.abs(nums[minIndex] - nums[j]);
            if(maxDiff >= valueDifference){
                return new int[] {maxIndex, j};
            }
            if(minDiff >= valueDifference){
                return new int[] {minIndex, j};
            }
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end

