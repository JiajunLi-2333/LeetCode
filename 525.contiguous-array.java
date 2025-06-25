/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map =  new HashMap<>();
        map.put(0, 0); // Initialize the map with 0 sum at index 0
        //todo This is to handle the case where the entire array is balanced
        int ans = 0, n = nums.length;
        int[] preSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + (nums[i] == 0? -1 : 1);
        }
        for(int i = 0; i <= n; i++){
            if(map.containsKey(preSum[i])){
                ans = Math.max(ans, i - map.get(preSum[i])); // i - map.get(preSum[i]) is the length of the subarray
            } else {
                map.put(preSum[i], i);
            }
        }
        return ans;
    }
}
// @lc code=end

