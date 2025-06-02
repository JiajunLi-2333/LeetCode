/*
 * @lc app=leetcode id=2390 lang=java
 *
 * [2390] Removing Stars From a String
 */
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

