/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */
/*
Clarify:
The nesting depth == the number of consecutive ( that has not been cancelled by the ). Question is too easy so no more further explanation
*/
// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int ans = 0, cur = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cur++;
                ans = Math.max(ans, cur);
            }else if(c == ')'){
                cur--;
            }
        }
        return ans;
    }
}
// @lc code=end

