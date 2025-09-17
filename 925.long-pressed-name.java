/*
 * @lc app=leetcode id=925 lang=java
 *
 * [925] Long Pressed Name
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int left = 0, right = 0;
        int n  = name.length(), m = typed.length();
        while(left < n && right < m){
            char cName = name.charAt(left);
            char cTyped = typed.charAt(right);
            if(cName == cTyped){
                left++;
                right++;
            }
            else{
                if(right == 0) return false;
                while(right < m -1 && typed.charAt(right) == typed.charAt(right - 1)){
                    right++;
                }
                if(name.charAt(left) == typed.charAt(right)){
                    left++;
                    right++;
                }
                else return false;
            }
            
        }
        if(left < n) return false;
        while(right < m){
            if(typed.charAt(right) != typed.charAt(right - 1)) return false;
            right++;
        }
        return true;
    }
}
// @lc code=end

