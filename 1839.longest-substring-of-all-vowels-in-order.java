/*
 * @lc app=leetcode id=1839 lang=java
 *
 * [1839] Longest Substring Of All Vowels in Order
 */

// @lc code=start
class Solution {
    public int longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) < word.charAt(i - 1)){
                type = 1;
                len = 1;
            } else if(word.charAt(i) == word.charAt(i - 1)){
                len++;
            } else {
                type++;
                len++;
            }
            if(type == 5) ans = Math.max(ans, len);
        }
        return ans;
        
    }
}
// @lc code=end

