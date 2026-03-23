/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preOps = '+';
        int num = 0;
        for(int i  = 0; i < s.length(); i++){
            char  c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                switch(preOps){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num);
                }
                num = 0;
                preOps = c;
            }

        }
        int ans = 0; 
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
// @lc code=end

