/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        // if ( then it should enter the stack directly
        // if ) then check the top of the stack to see if it can be removed
        Stack<Character> res = new Stack<>();
        for(char c: s.toCharArray()){
            if(!res.isEmpty() && res.peek() == '(' && c == ')'){
                res.pop();
            }else {
                res.push(c);
            }
        }
        return res.size();

    }
}
// @lc code=end

