/*
 * @lc app=leetcode id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> opStack = new ArrayDeque<>(); //符号栈
        Deque<Character> boolStack = new ArrayDeque<>(); //布尔值

        for(char c : expression.toCharArray()){
            if(c == '!' || c == '|' || c == '&'){
                opStack.push(c);
            }
            if(c == 'f' || c == 't'){
                boolStack.push(c);
            }
            if(c == ',') continue;
            if(c == '(') boolStack.push('-');
            if(c == ')'){
                char op = opStack.pop(), cur = ' ';
                while(!boolStack.isEmpty() && boolStack.peek() != '-'){
                    char top = boolStack.pop();
                    cur = cur == ' ' ? top : calc(top, cur, op);
                }
                if(op == '!') cur = cur == 't' ? 'f' : 't';
                boolStack.pop();
                boolStack.push(cur);

            }
        }
        return boolStack.peek() == 't';
    }
    private char calc(char a, char b, char op){
        boolean x = a == 't', y = b == 't';
        boolean ans = op == '|' ? x | y : x & y;
        return ans ? 't' : 'f';
    }
}
// @lc code=end

