

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */
// @lc code=start
import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) {
                stack.push(c);
            }else{
                if(c == stack.peek()){
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

