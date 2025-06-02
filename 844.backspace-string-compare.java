/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // time complexity: O(n + m)
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '#'){
                if(sb1.length() > 0){
                    sb1.deleteCharAt(sb1.length() - 1);
                }else{
                    continue;
                }
            }else{
                sb1.append(c);
            }
        }
        for(char c : t.toCharArray()) {
            if(c == '#'){
                if(sb2.length() > 0){
                    sb2.deleteCharAt(sb2.length() - 1);
                }else{
                    continue;
                }
            }else{
                sb2.append(c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
// @lc code=end

