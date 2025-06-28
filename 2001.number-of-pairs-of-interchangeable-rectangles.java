/*
 * @lc app=leetcode id=2001 lang=java
 *
 * [2001] Number of Pairs of Interchangeable Rectangles
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        //the ans is long because the number of rectangles can be large
        // long ans = 0;
        // Map<Double, Integer> map = new HashMap<>();
        // for(int[] rec: rectangles){
        //     double ratio = (double) rec[0] / rec[1];
        //     ans += map.getOrDefault(ratio, 0);
        //     map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        // }
        // return ans;
        Map<Double, Long> map = new HashMap<>();
        long ans = 0;
        for(int[] rec: rectangles){
            double ratio = (double) rec[0] / rec[1];
            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }
        for(long count: map.values()){
            if(count > 1){
                ans += count * (count - 1) / 2; // n choose 2
            }
        }
        return ans;
    }
}
// @lc code=end

