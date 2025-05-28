/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(nums[i])){
                minDis = Math.min(minDis, i - map.get(nums[i]));
                map.put(nums[i], i);
            }
            else{
                map.put(nums[i], i);
            }
            if (minDis <= k){
                return true;
            }
        }
        return false; 
    }
}
// @lc code=end

