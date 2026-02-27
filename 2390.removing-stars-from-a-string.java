/*
 * @lc app=leetcode id=2390 lang=java
 *
 * [2390] Removing Stars From a String
 */
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    sb.deleteCharAt(sb.length() -1);
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();

        
    }
}
// @lc code=end

