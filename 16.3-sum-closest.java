/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //采用暴力枚举的方式
        // int n = nums.length;
        // int sum = 0;
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0; i < n - 2; i++){
        //     for(int j = i + 1; j < n - 1; j++){
        //         for(int k = j + 1; k < n; k++){
        //             sum = nums[i] + nums[j] + nums[k];
        //             if(Math.abs(sum - target) < Math.abs(ans - target)){
        //                 ans = sum;
        //             }
        //         }
        //     }
        // }
        // return ans;

        //排序 + 双指针 在枚举i端点的同时，使用指针来减少枚举的复杂度
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }
                if(sum > target){
                    right--;
                    if(Math.abs(sum - target) < Math.abs(ans - target)){
                        ans = sum;
                    }
                }else{
                    left++;
                    if(Math.abs(sum - target) < Math.abs(ans - target)){
                        ans = sum;
                    }
                }
            } 
        }
        return ans;
    }
}
// @lc code=end

