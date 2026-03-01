/*
 * @lc app=leetcode id=2909 lang=java
 *
 * [2909] Minimum Sum of Mountain Triplets II
 */

// @lc code=start
class Solution {
    public int minimumSum(int[] nums) {
        //A silly way: which causes TLE
        // int n = nums.length;
        // int ans = Integer.MAX_VALUE;
        // for(int j = 1; j < n - 1; j++){
        //     for(int i = 0; i < j; i++){
        //         if(nums[i] >= nums[j]) continue;
        //         for(int k = j + 1; k < n; k++){
        //             if(nums[k] >= nums[j]) continue;

        //             if(nums[i] < nums[j] && nums[j] > nums[k]){
        //                 ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
        //             }
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;

        int n = nums.length; 
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];//后缀最小值
        for(int i = n - 2; i > 0; i--){
            suf[i] = Math.min(suf[i+ 1], nums[i]);
        }

        int[] pre = new int[n];
        pre[0] = nums[0];
        int ans = Integer.MAX_VALUE;
        for(int j = 1; j < n -1; j++){
            if(pre[j - 1] < nums[j] && suf[j + 1] < nums[j]){
                ans = Math.min(pre[j - 1] + nums[j] + suf[j + 1], ans);
            }
            pre[j] = Math.min(pre[j -1], nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

