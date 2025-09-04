/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */
import java.util.*;
// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        // Arrays.sort(nums);
        // int ans = 0;
        // int n = nums.length;
        // for(int i = 0; i < n - 2; i++){
        //     for(int j = i + 1; j < n -1; j++){
        //         for(int k = j + 1; k < n; k++){
        //             if(nums[i] + nums[j] > nums[k]){
        //                 ans++;
        //             }
        //         }
        //     }
        // }
        // return ans;
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for(int i = n -1; i >=2; i--){
            int left = 0, right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    ans += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

