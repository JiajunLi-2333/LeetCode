/*
 * @lc app=leetcode id=2197 lang=java
 *
 * [2197] Replace Non-Coprime Numbers in Array
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for(int num : nums){
            stack.add(num);
            while(stack.size() > 1 && GCD(stack.getLast(), stack.get(stack.size() - 2)) > 1){
                int last = stack.removeLast();
                int prev = stack.removeLast();
                stack.add(LCM(last, prev));
            }
        }
        return stack;

    }

    private int GCD(int a, int b ){
        while(b != 0){
            int tmp = b; 
            b = a % b; 
            a = tmp;
        }
        return a;
    }
    private int LCM(int a, int b){
        return a /GCD(a,b) * b;
    }
}
// @lc code=end

 