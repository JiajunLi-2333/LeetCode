/*
 * @lc app=leetcode id=2696 lang=java
 *
 * [2696] Minimum String Length After Removing Substrings
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && 
                ((stack.peek() == 'A' && c == 'B') ||
                (stack.peek() == 'C' && c == 'D'))){
                  stack.pop();  
            } else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}
// @lc code=end

