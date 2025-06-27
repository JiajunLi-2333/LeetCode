/*
 * @lc app=leetcode id=1546 lang=java
 *
 * [1546] Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        // Greedy + HashMap
        //! The key is to fulfill the requirement of non-overlapping subarrays -- use a variable to remember the last index of the subarray that has been counted
        int n = nums.length, ans = 0, last = 0;
        int[] preSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();//sum as key, index as value
        map.put(0,0);
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for(int i = 1; i <= n; i++){
            int sum = preSum[i];
            if(map.containsKey(sum - target) && map.get(sum - target) >= last){
                ans++;
                last = i;
            }
            map.put(sum, i);
        }
        return ans;    
    }
}
// @lc code=end

