/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int t : time){
            int mod = t % 60;
            int comp = (60 - mod) % 60;
            ans += map.getOrDefault(comp, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

