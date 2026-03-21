/*
 * @lc app=leetcode id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 */
import java.util.*;
/*
Clarify:
valid string is made of combinations of "abc" and the goal aims to test whether string s is valid or not.
Brutal:
use a while loop and a sliding window of size 3. Once we find "abc" in our window, delete it. If stirng is empty at the end, then it is valid.
Bottleneck:
the left string and right string after removal may form a new "abc", that is why we need to repeatedly slide over the string to remove it. 
Keyword:adjacent removal + nested structure -> stack.
Optimize: use a stack to represent the left string, pop happens when "ab" "c" happens. If stack is empty by the end, then s is valid.
*/
// @lc code=start
class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.size() > 1 && stack.get(stack.size() - 1) == 'b' && stack.get(stack.size() - 2) == 'a' && c == 'c'){
                stack.remove(stack.size() -1);
                stack.remove(stack.size() -1);
            }else{
                stack.add(c);
            }
        }
        return stack.size() == 0;
    }
}
// @lc code=end

