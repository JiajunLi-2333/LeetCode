/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int left = 0, right = 0,ans = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                left++;
            }
            if(c == ')'){
                right++;
            }
            if(left >= right){
                ans = Math.max(left - right, ans);
                left -= right;
                right = 0;
            }
        }
        return ans; 
    }
}
// @lc code=end

