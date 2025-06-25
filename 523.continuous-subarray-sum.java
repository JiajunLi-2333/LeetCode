/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        //store index of the first occurrence of each remainder
        //1 <= k <= 10^9
        //0 <= nums[i] <= 10^9
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // to handle the case when the sum is exactly a multiple of k at the start
        int n = nums.length, sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int mod = sum %k;
            if(map.containsKey(mod)){
                //check if the subarray length is at least 2
                if(i - map.get(mod) > 1) return true;
            }else{
                //store the first occurrence of the remainder
                map.put(mod, i);
            }
        }
        return false;
        
        
    }
}
// @lc code=end

