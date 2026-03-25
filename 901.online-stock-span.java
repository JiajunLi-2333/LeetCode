/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */
/*
Clarify:
For every i, we need to find j st j < i and nums[j] > nums[i]

Brutal:
Initialize a num array, for every new price, iterate to the right to find the bigger element. tc O(n^2) sc O(n)

Bottleneck:
We are look for the next greater element each time, so it is better if we can have some context memory that records the element for us

Optimize:
use a Dec stack and store int[price, span] for good.

Keyword: next greater element + dynamically maintaining -> monotonic stack && the use of stack
*/

import java.util.*;
// @lc code=start
class StockSpanner {
    Deque<int[]> stack;
    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
       if(stack.isEmpty()){
        stack.push(new int[]{price,1});
        return stack.peek()[1];
       }
       int span = 1;
       while(!stack.isEmpty() && stack.peek()[0] <= price){
        span += stack.pop()[1];
       }
       stack.push(new int[]{price,span});
       return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

