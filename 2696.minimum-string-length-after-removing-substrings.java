/*
 * @lc app=leetcode id=2696 lang=java
 *
 * [2696] Minimum String Length After Removing Substrings
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int minLength(String s) {
        int i  = 1, n = s.length(); 
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        while(i < n){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == 'B' && stack.peek() == 'A'){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == 'D' && stack.peek() == 'C'){
                stack.pop();
            }else{
                stack.push(c);
            }
            i++;
        }
        return stack.size();
    }
}
// @lc code=end

