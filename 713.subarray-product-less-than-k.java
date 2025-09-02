/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int ans = 0; 
        int product = 1;
        
        int left = 0;
        for(int i = 0; i < nums.length;i++){
            product *= nums[i];
            while(product >= k){
                product /= nums[left++];
            }
            ans += i -left + 1;
        }
        return ans;

    }
}
// @lc code=end

