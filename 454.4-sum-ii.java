/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */
import java.util.HashMap;
import java.util.Map;  
// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                map.merge(i + j, 1, Integer::sum);
            }
        }
        int ans = 0;
        for(int i : nums3){
            for(int j : nums4){
                ans += map.getOrDefault(-(i + j), 0);
            }
        }
        return ans;
    }
}
// @lc code=end

