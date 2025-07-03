/*
 * @lc app=leetcode id=1475 lang=java
 *
 * [1475] Final Prices With a Special Discount in a Shop
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] ans =  new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        //fill remaining elements
        while(!stack.isEmpty()){
            int idx = stack.pop();
            ans[idx] = prices[idx];
        }
        return ans;
    }
}
// @lc code=end

