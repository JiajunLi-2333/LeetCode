/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
import java.util.*;
// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(token.length() > 1 || Character.isDigit(token.charAt(0)) == true){
                stack.push(Integer.parseInt(token));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "/": stack.push(b / a); break;
                    case "-": stack.push(b - a); break;
                    case "*": stack.push(a * b); break;
                }
            }
        }
        return stack.peek();
    }
}
// @lc code=end

