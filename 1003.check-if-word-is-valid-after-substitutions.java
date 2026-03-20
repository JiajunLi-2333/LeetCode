/*
 * @lc app=leetcode id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.add(c);
            }
            else{
                if(c == 'c' && stack.size() > 1 &&stack.get(stack.size() 
                 - 1) == 'b' && stack.get(stack.size() - 2) == 'a'){
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);

                }
                else{
                    stack.add(c);
                }
            }
        }
        return stack.size() == 0;
    }
}
// @lc code=end

