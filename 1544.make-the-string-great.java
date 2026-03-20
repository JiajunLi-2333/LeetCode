/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
import java.util.*;
class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(Math.abs(stack.peek()-c) == 32){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());    
        }
        return ans.reverse().toString();
    }
}
// @lc code=end

