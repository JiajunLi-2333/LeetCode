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
        //clarification
        //give two-dimensional array, find tuple i, j ,k st d_ij = d_ik
        //order matters -> (i,j,k) != (i, k, j)

        //1 <= n <= 500
        // points[i].length == 2 
        // all points are unique

        //edge cases
        //points.length < 3 return 0
        //if all the points are on the same line.
        //(2*10^4)^2 + (2*10^4)^2 = 8 * 10^8 -> int
        // (i, j, k) form a unilateral triangle -> 6 because order matters and each point can be the i point

        //solution 
        //Intuitive: nested for loop
        //outer loop O(n^3) O(n)

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] p1 : points){
            map.clear();
            for(int[] p2 : points){
                int d2 = (p1[0] - p2[0]) * (p1[0] - p2[0]) +(p1[1] - p2[1]) * (p1[1] - p2[1]);
                int cnt = map.getOrDefault(d2, 0);
                ans += cnt * 2;
                map.merge(d2, 1, Integer::sum);
            }
        }
        return ans;
    }
    
}
// @lc code=end

