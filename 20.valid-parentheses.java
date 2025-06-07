/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
import java.util.Stack;
import java.util.List;
// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> ans = new Stack<>();
        List<Integer> sumlist = List.of(81,184,248);
        for(char c: s.toCharArray()){
            if(!ans.isEmpty() && sumlist.indexOf((int) (ans.peek() + c)) != -1 && (int) c > (int) ans.peek()){
                ans.pop();
            }else ans.push(c);
        }
        return ans.isEmpty();
    }
}
// @lc code=end

