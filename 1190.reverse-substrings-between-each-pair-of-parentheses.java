/*
 * @lc app=leetcode id=1190 lang=java
 *
 * [1190] Reverse Substrings Between Each Pair of Parentheses
 */
import java.util.*;
// @lc code=start
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 预处理：建立括号配对关系
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        // 虫洞穿越
        StringBuilder sb = new StringBuilder();
        int i = 0, dir = 1; // dir = 1 向右, dir = -1 向左
        while (i >= 0 && i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i]; // 跳到配对括号
                dir = -dir;  // 反转方向
            } else {
                sb.append(s.charAt(i));
            }
            i += dir;
        }
        
        return sb.toString();
    }
}
// @lc code=end

