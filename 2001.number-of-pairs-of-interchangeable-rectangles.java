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
        
        //clarification
        //Given rectangles, count the number of pairs that have the same width to height ratio

        //constraints
        // n == rectangles.length
        // 1 <= n <= 10^5
        // rectangles[i].length == 2
        // 1 <= widthi, heighti <= 10^5
        // use decimal division (explicit casting)

        //edge cases
        // rectangles = [[1,1]] -> 0
        // rectangles [[a,b],[c,d]] -> 0
        // rectangles [[a,b][a,b][a,b][a,b]] -> 3 + 2 + 1 = 7

        //solution:
        Map<Double, Integer> map = new HashMap<>();
        long ans = 0;
        for(int[] rec : rectangles){
            double ratio = (double) rec[0] / rec[1];
            ans += map.getOrDefault(ratio,0);
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

