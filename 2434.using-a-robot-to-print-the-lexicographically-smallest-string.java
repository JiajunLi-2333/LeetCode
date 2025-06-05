/*
 * @lc app=leetcode id=2434 lang=java
 *
 * [2434] Using a Robot to Print the Lexicographically Smallest String
 */

// @lc code=start
import java.util.Stack;
class Solution {
    public String robotWithString(String s) {
        //use prefix to store the smallest character from the right

        //Again the idea of using prefix
        int n = s.length();
        char[] prefix = new char[n + 1];
        prefix[n] = Character.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            prefix[i] = (char) Math.min(s.charAt(i), prefix[i + 1]);
        }
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(s.charAt(i));
            while(!stack.isEmpty() && stack.peek() <= prefix[i + 1]){
                ans.append(stack.pop());
            }
        }
        return ans.toString();

     }
}
// @lc code=end

