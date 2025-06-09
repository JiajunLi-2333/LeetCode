/*
 * @lc app=leetcode id=1190 lang=java
 *
 * [1190] Reverse Substrings Between Each Pair of Parentheses
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public String reverseParentheses(String s) {
        //use a StringBuilder to reverse the string and simulate the stack process
        //use a stack to store the index of each left parenthesis
        Stack<Integer> indexStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){

            //record the index of each of the ( parenthesis
            if(c[i] == '('){
                indexStack.push(sb.length());
            }
            else if(c[i] == ')'){
                int startIndex = indexStack.pop();
                int endIndex = sb.length();
                sb.replace(startIndex, endIndex, new StringBuilder(sb.substring(startIndex, endIndex)).reverse().toString());

            }else{
                sb.append(c[i]);
            }

        }
        return sb.toString();
    }
}
// @lc code=end

