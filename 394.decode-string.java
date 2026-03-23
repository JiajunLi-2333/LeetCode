/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */
import java.util.*;
// @lc code=start
class Solution {
    private record Pair(String s, int k){

    }
    public String decodeString(String s) {
        Deque<Pair> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0; 
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                cur.append(c);
            }else if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(c == '['){
                stack.push(new Pair(cur.toString(), k));
                cur.setLength(0);
                k = 0;
            }else{
                Pair p = stack.pop();
                cur = new StringBuilder(p.s).repeat(cur, p.k);
            }
        }
        return cur.toString();
    }

}
// @lc code=end

