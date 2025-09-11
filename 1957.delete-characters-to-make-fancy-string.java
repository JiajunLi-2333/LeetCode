/*
 * @lc app=leetcode id=1957 lang=java
 *
 * [1957] Delete Characters to Make Fancy String
 */
import java.util.*;
// @lc code=start
class Solution {
    public String makeFancyString(String s) {
        //! Approach 1: stack: Slow but works
        // Deque<Character> stack = new ArrayDeque<>();
        // int cnt = 0;
        // for(char c : s.toCharArray()){
        //     if(!stack.isEmpty() && stack.peek() == c){
        //         cnt++;
        //         if(cnt < 2){
        //             stack.push(c);
        //         }
        //     }
        //     else{
        //         cnt = 0;
        //         stack.push(c);
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while(!stack.isEmpty()){
        //     sb.append(stack.pollLast());
        // }
        // return sb.toString();
        //! Approach 2: Use Two pointers
        
    }
}
// @lc code=end

