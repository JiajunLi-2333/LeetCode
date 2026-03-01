/*
 * @lc app=leetcode id=1475 lang=java
 *
 * [1475] Final Prices With a Special Discount in a Shop
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        //clarification
        //given prices, we need to return an array ans
        //ans[i] = prices[i] - prices[j]
        //The rule dictates that j > i, closest to i  and prices[j] <= prices[i]
        // if no such j exists, ans[i] = prices[i]

        //constraints 
        //1 <= prices.length <= 500
        //1 <= prices[i] <= 1000

        //edge case 
        // prices = [10] ans = [10] 
        // prices increasing ans equals to prices
        // prices all the same values = ans equals prices
        // prices decreasing [5,4,3,2,1] ans = [1,1,1,1,1]
        // prices = [10,1,1,6] = [9,0,1,6]
        // no worries about overflows

        //solution:
        //Intuitive solution: two nested for loops
        //outer for loop iterates price[i] and the inner loop finds the cloest discount (from left to right to make sure that j > i) 通过暴力解来更好的理解问题

        Deque<Integer> stack = new ArrayDeque<>();
        int n = prices.length; 
        for(int j = 0; j < n; j++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[j]){
                int index = stack.pop();
                prices[index] = prices[index] - prices[j];
            }
            stack.push(j);
        }
        return prices;
    }
}
// @lc code=end

