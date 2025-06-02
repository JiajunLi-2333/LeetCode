/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] point: points){
            map.clear();
            for(int[] point2: points){
                int dist = getDistance(point, point2);
                ans += 2 * map.getOrDefault(dist, 0);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
        }
        return ans;
    }
    private int getDistance(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + 
               (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
// @lc code=end

