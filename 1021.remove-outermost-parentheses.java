/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */
import java.util.*;

/*
Clarify: 
the input s can be divided into n primitive strings, for each of the primitive strings, remove the outermost parenthesis.
Brutal:
The overall idea is to find each of the primitive string and perform the deletion. We find a primitive string if # of ( == # of ). So a two pointer solution already works in O(n) TC and O(1) SC.
Optimize: 
Try to see this problem in a different way, the result of the outer depends on the state of the inner, so use a stack to track the state of the nesting and perform any operation.
Keyword:
Nested tracking -> stack
*/
// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        //TODO Brutal Solution Two Pointers
        /* char[] cs = s.toCharArray();
        int n = cs.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0, score = 0; i < n;){
            int j = i;
            while(i == j || score != 0) score += cs[j++] == '(' ? 1 : -1;
            sb.append(s.substring(i + 1, j - 1));
            i = j;
            score = 0;
        }
        return sb.toString(); */

        //TODO Stack Solution
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder(); 
        for(char c : s.toCharArray()){
            if(c == '('){
                if(!stack.isEmpty()){
                    ans.append(c);
                }
                stack.push(c);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    
    }
}
// @lc code=end

