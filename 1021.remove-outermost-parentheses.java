/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */
import java.util.*;
// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        //TODO Clarification
        //TODO  s = (()())(())(()(())) can be divided into
        //TODO (()()) + (()) + (()(())), remove all the outermost parenthesis
        //TODO ()() + () + ()(())

        int depth = 0; 
        StringBuilder ans = new StringBuilder(); 
        for(char c : s.toCharArray()){
            if(c == '('){
                if(depth > 0) ans.append(c);
                depth++;
            }
            else{
                depth--;
                if(depth > 0) ans.append(c);
            }
        }
        return ans.toString();
        



    }
}
// @lc code=end

