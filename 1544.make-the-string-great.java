/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        int diff = 97 - 65;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!ans.isEmpty() && Math.abs(ans.charAt(ans.length() -1) - c) == diff ){
                ans.deleteCharAt(ans.length() -1);
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
// @lc code=end

