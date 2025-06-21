/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        //My solution was to use two stacks, one for the opening parentheses and one for the closing parentheses.
        //However, I realized that I could use a single stack to keep track of the indices of the parentheses that need to be removed.
        //This way, I can avoid using extra space for the second stack and simplify the logic.

        //! great optimization
        int[] remove = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    remove[i] = 1; // Mark this ')' for removal
                }
            }
        }
        while (!stack.isEmpty()) {
            remove[stack.pop()] = 1; // Mark unmatched '(' for removal
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (remove[i] == 0) {
                result.append(s.charAt(i)); // Append only valid characters
            }
        }
        return result.toString();

    }
}
// @lc code=end

