/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
import java.util.*;
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, n = s.length(), ans = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            //increment the count of c as entering the window
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(left < right && map.getOrDefault(c, 0) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                left++;
            }
        
            ans = Math.max(ans, right - left + 1);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
// @lc code=end

