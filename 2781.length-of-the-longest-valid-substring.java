/*
 * @lc app=leetcode id=2781 lang=java
 *
 * [2781] Length of the Longest Valid Substring
 */
import java.util.*;
// @lc code=start
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Map<String, Integer> forbiddenMap = new HashMap<>();
        for (String s : forbidden) {
            forbiddenMap.put(s, 1);
        }
        int left = 0;
        int ans = 0;
        int n = word.length();
        for(int i = 0; i < n; i++){
            for(int j = i; j >= left && j > i - 10; j--){
                if(forbiddenMap.containsKey(word.substring(j, i + 1))){
                    left = j + 1;
                }
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
// @lc code=end

