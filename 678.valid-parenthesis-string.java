/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left.push(i);
            } else if(c == '*'){
                star.push(i);
            } else {
                if(!left.isEmpty()){
                    left.pop();
                } else if(!star.isEmpty()){
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            if(left.peek() < star.peek()){
                left.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return left.isEmpty();
    }
}
// @lc code=end

