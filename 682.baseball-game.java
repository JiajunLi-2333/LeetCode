/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int calPoints(String[] operations) {
       Stack<Integer> stack = new Stack<>();
       int ans = 0;

       for(String operation : operations){
            if(operation.equals("C")){
                stack.pop();
            }
            else if(operation.equals("D")){
                stack.push(2 * stack.peek());
            }else if(operation.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            }
            else{
                stack.push(Integer.parseInt(operation));
            }
       }
       while(!stack.isEmpty()){
        ans += stack.pop();
       }
       return ans; 
    }
}
// @lc code=end

