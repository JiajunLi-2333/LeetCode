/*
 * @lc app=leetcode id=1006 lang=java
 *
 * [1006] Clumsy Factorial
 */
import java.util.*;

// @lc code=start
// class Solution {
//     public int clumsy(int n) {
//         Deque<Integer> stack = new ArrayDeque<>();
//         char[] operand = new char[]{'*', '/','+','-'};
//         int i = 0;
//         stack.push(n--);
//         while(n > 0){
//             switch (operand[i % 4]) {
//                 case '*':
//                     int val = stack.pop();
//                     stack.push(n*val);
//                     break;
            
//                 case '/':
//                     int res = stack.pop();
//                     stack.push(res / n);
//                     break;

//                 case '+':
//                     stack.push(n);
//                     break;
//                 case '-':
//                     stack.push(-n);
//                     break;
//             }
//             i++;
//             n--;
//         }
//         int ans = 0; 
//         while(!stack.isEmpty()){
//             ans += stack.pop();
//         }
//         return ans;
//     }
// }

class Solution {
    public int clumsy(int n) {
        int[] special = new int[]{1,2,6,7};
        int[] diff = new int[]{1,2,2,-1};
        if (n <= 4) return special[(n - 1) % 4];
        return n + diff[n % 4];
    }
}
// @lc code=end

