/*
 * @lc app=leetcode id=1446 lang=java
 *
 * [1446] Consecutive Characters
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxPower(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 1;
        int left = 0; 
        int n = s.length();
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(left < right && map.size() > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

