/*
 * @lc app=leetcode id=2116 lang=java
 *
 * [2116] Check if a Parentheses String Can Be Valid
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean canBeValid(String s, String locked) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> unlocked = new ArrayDeque<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            char lock = locked.charAt(i);
            if(lock == '0'){
                unlocked.push(i);
            }
            if(lock == '1'){
                if(c == '('){
                    left.push(i);
                }
                else{
                    if(!left.isEmpty()){
                        left.pop();
                    }else if(!unlocked.isEmpty()){
                        unlocked.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        while(!left.isEmpty()){
            if(unlocked.isEmpty()) return false;
            if(left.pop() > unlocked.pop()) return false;
        }
        if(unlocked.size() % 2 == 1) return false;
        return true;
    }
}
class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 > 0) {
            return false;
        }
        int mn = 0;
        int mx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') { // 不能改
                int d = s.charAt(i) == '(' ? 1 : -1;
                mx += d;
                if (mx < 0) { // c 不能为负
                    return false;
                }
                mn += d;
            } else { // 可以改
                mx++; // 改成左括号，c 加一
                mn--; // 改成右括号，c 减一
            }
            if (mn < 0) { // c 不能为负
                mn = 1; // 此时 c 的取值范围都是奇数，最小的正奇数是 1
            }
        }
        return mn == 0; // 说明最终 c 能是 0
    }
}
// @lc code=end

