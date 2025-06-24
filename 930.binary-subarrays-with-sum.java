/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 having one occurrence
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int complement = sum - goal;
            if(map.containsKey(complement)){
                ans += map.get(complement);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

