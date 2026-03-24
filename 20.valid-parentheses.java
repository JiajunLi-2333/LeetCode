/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    if(c == ')' && stack.peek() == '(') stack.pop();
                    else if(c == ']' && stack.peek() == '[') stack.pop(); 
                    else if(c == '}' && stack.peek() == '{') stack.pop();
                    else stack.push(c);
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

