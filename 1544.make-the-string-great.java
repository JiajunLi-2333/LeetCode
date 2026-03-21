/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
import java.util.*;
/*
clarify: Remove paris of same letter where lower case == upper case. After removal, the rest of string will concate.
brutal: use while loop, each time use a window of size 2 to find all the pairs to remove until we cannot find any pairs.
bottleneck: After removing a pair, we do not know whether the left and right string will lead to another removal.
keyword: adjacent removal -> stack
optimize:use a stack to store all the valid characters, pop when removal happens between the top of the stack and the next char in the string.

*/
class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32){
                stack.pop();
            }else{//stack is empty or the removal does not happen
                stack.push(c);
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

