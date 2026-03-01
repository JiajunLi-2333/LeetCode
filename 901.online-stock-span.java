/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */
import java.util.*;
// @lc code=start
class StockSpanner {

    private Deque<int[]> stack = new ArrayDeque<>();
    private int cur = -1;
    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        while(price >= stack.peek()[1]){
            stack.pop();
        }

        cur++; 
        int ans = cur - stack.peek()[0];
        stack.push(new int[]{cur, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

