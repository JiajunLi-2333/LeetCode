/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */
/*
Clarify:
The string s is already balanced -> every ( has a ). "()" has one point, AB = A + B. (A) = 2 * A. 
?:
Example (()((())))() = 2*(1 + 2*(2 * 1)) + 1 = 11
Brutal: Let us abstract s = A + B + C where A, B, C are all balanced parentheses strings that constitutes strings. we can identify each one of them by # of ( == # of ). And we can recursively calculate A, B, C, add them up and spawn the answer. So this can be solved by Recursion. TC O(n^2);
Bottleneck:
We are scaning the string over and over here because we do not know which layer we are at right now so we do not know whether we need to do addition or multiplication.And it would be so much better if we could know which layer we are at right now
Keyword: Nested tracking -> stack
Optimize:
use a stack to keep track of the layer, all ( gets an initial value 0 and being updated when we have met a ).
*/
import java.util.*;
// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
      /*   if(s.equals("()")){
            return 1;
        }
        int boundary = 0; 
        for(int i = 0; i < s.length(); i++){
            boundary += s.charAt(i) == '(' ? 1 : -1;
            if(boundary == 0){
                if(i == s.length() -1){
                    return 2 * scoreOfParentheses(s.substring(1,s.length() -1));
                }else{
                    return scoreOfParentheses(s.substring(0, i + 1)) + scoreOfParentheses(s.substring(i+ 1));
                }
            }
        }
        return 0; */

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }else{
                int cur = stack.pop(); 
                stack.push(stack.pop() + Math.max(cur * 2, 1));
            }
        }
        return stack.peek();
    }
}
// @lc code=end

