/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

/*
Clarify:
So s is gauranteed to be a valid expression made of addition, subtraction and parenthesis. And arithematic order matters here to calculate the result.
Brutal:
initialize while loop to finish all the calculation within parenthesis and then in one loop, calculate the result by addition. Alternatively, we can use recursion to calculate the result




*/
import java.util.*;

// @lc code=start
class Solution{
    public int calculate(String s){
        Deque<Integer> stack = new ArrayDeque<>(); 
        int ans = 0, sign = 1, num = 0; //sign == 1 stands for positive
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else if(c == '+'){
                ans += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                ans += sign * num;
                num = 0; 
                sign = -1;
            }else if (c == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }else if(c == ')'){
                ans += sign * num;
                num = 0;
                ans *= stack.pop();
                ans += stack.pop();
            } 
        }
        ans += sign * num;
        return ans;
    }
}

//TODO solve by recursion
// class Solution {
//     int i = 0;
//     public int calculate(String s) {
//         return recursion(s);
//     }
//     private int recursion(String s){
//         int res = 0;
//         int sign = 1;
//         int num = 0;

//         while(i < s.length()){
//             char c = s.charAt(i);
//             i++;
//             if(Character.isDigit(c)){
//                 num = num * 10 + (c - '0');
//             }
//             else if(c == '+'){
//                 res += sign * num;
//                 num = 0;
//                 sign = 1;
//             }else if(c == '-'){
//                 res += sign * num;
//                 sign = -1; 
//                 num = 0;
//             }else if(c == '('){
//                 res += sign *recursion(s);
//             }else if (c == ')'){
//                 res += sign * num; 
//                 return res;
//             }
//         }
//         res += sign *num;
//         return res;
//     }
// }
// @lc code=end

