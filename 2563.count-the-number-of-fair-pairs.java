/*
 * @lc app=leetcode id=2563 lang=java
 *
 * [2563] Count the Number of Fair Pairs
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        //可以使用枚举策略 
        //两次想向双指针优化策略
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);

    }
    private long count(int[] nums, int upper){
        long ans = 0; 
        int n = nums.length;
        int right = n -1;
        for(int i = 0; i < n; i++){
            while(right > i && nums[right] > upper - nums[i]){
                right--;
            }
            if(right == i) break;
            ans += right - i;
        }
        return ans;
    }
}
// @lc code=end

