/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        // ((())) score = 1 * 2 * 2 = 2 ^ 2 = 4
        // ((())((()))()) score = (2^1 + 2^2 + 2^0) + 2
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }
            else{
                int cur = stack.pop();
                stack.push(stack.pop() + Math.max(cur * 2, 1));
            }
        }
        return stack.peek();
        

    }
}
// @lc code=end

