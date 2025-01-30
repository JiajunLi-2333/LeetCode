/*
 * @lc app=leetcode id=713 lang=cpp
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int result = 0;
        int size = nums.size();
        for(int left = 0; left < size; left++){
            int product = 1;
            for (int right = left; right < size; right++){
                product *= nums[right];
                if(product <= k){
                    result++;
                }else{
                    break;
                }
            }
        }
    }
};
// @lc code=end

