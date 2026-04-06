/*
 * @lc app=leetcode id=1354 lang=java
 *
 * [1354] Construct Target Array With Multiple Sums
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1){
            return target[0] == 1;
        }
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        long sum = 0;
        for(int num : target){
            sum += num;
            maxHeap.offer((long) num);
        }

        while(maxHeap.peek() > 1){
            long x = maxHeap.poll();
            long rest = sum - x;

            if(rest == 0 || rest > x) return false;
            if(rest == 1) return true;

            long val = x % rest;
            if(val == 0) return false;

            sum = rest +val;
            maxHeap.offer(val);
        }
        return true;

    }
}
// @lc code=end

