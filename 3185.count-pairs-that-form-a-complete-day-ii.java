/*
 * @lc app=leetcode id=3185 lang=java
 *
 * [3185] Count Pairs That Form a Complete Day II
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int hour : hours){
            int mod = hour % 24;
            int complement = (24 - mod) % 24;  
            ans += map.getOrDefault(complement, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

