/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */
import java.util.*;
// @lc code=start
class StockSpanner {

    private Stack<int[]> stack = new Stack<>();
    private int day = -1;
    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE}); // Initialize with a dummy value so we do not need to check for empty stacks

    }
    
    public int next(int price) {
        while(price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = ++day - stack.peek()[0];
        stack.push(new int[]{day, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

