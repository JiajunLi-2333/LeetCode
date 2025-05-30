/*
 * @lc app=leetcode id=2260 lang=java
 *
 * [2260] Minimum Consecutive Cards to Pick Up
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++){
            if(map.containsKey(cards[i])){
                ans = Math.min(ans, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
         }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// @lc code=end

