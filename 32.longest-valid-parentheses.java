/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
import java.util.*;
// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        List<Integer> stk = new ArrayList<>();
        stk.add(-1); 
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { 
                stk.add(i);
            } else if (stk.size() > 1) { 
                stk.removeLast();
                ans = Math.max(ans, i - stk.getLast()); 
            } else {
                stk.set(0, i); 
            }
        }
        return ans;
    }
}
// @lc code=end

