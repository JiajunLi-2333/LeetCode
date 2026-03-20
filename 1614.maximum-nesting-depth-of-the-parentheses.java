/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cur = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cur++;
                ans = Math.max(ans, cur); 
            }
            if(c == ')'){
                cur--;
            }
        }
        return ans;
    }
}
// @lc code=end

