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
        int ans = Integer.MAX_VALUE, preMIN = nums[0];
        int[] RightMIN = new int[n];
        RightMIN[n - 1] = nums[n - 1];
        for(int i = n -2; i > 1; i--){
            RightMIN[i] = Math.min(RightMIN[i + 1], nums[i]);
        }

        for(int i = 1; i < n -1; i++ ){
            if (preMIN < nums[i] && RightMIN[i + 1] < nums[i]){
                ans = Math.min(ans, preMIN + nums[i] + RightMIN[i + 1]);
            }
            preMIN = Math.min(preMIN, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
// @lc code=end

