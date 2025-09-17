/*
 * @lc app=leetcode id=2337 lang=java
 *
 * [2337] Move Pieces to Obtain a String
 */

// @lc code=start
class Solution {
    public boolean canChange(String start, String target) {
        if(start.replace("_", "").equals(target.replace("_", "")) == false) return false;
        int n = start.length();
        int left = 0, right = 0;
        while(left < n && right < n){
            if(start.charAt(left) == '_'){
                left++;
                continue;
            }
            while(target.charAt(right) == '_'){
                right++;
            }
            if(start.charAt(left) == 'L' && left < right) return false;
            if(start.charAt(left) == 'R' && left > right) return false;
            left++;
            right++;
        }
        return true;
        
    }
}
// @lc code=end

