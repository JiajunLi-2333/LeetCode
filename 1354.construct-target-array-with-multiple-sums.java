/*
 * @lc app=leetcode id=1354 lang=java
 *
 * [1354] Construct Target Array With Multiple Sums
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public boolean isPossible(int[] target) {
        //reverse the array and use priority queue to simulate the process
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        long sum = 0;
        for(int num : target){
            pq.offer(num * 1L);
            sum += num;
        }
        while(!pq.isEmpty() && pq.peek() > 1){
            Long cur = pq.poll();
            sum -= cur;
            if(sum <= 0 || sum >= cur) return false;
            //calculate the new value to be added back to the queue


            //This solves the problem of newVal is still or not the largest value in the queue 
            Long newVal = cur % sum;
            if(newVal == 0) newVal = sum; //if cur is a multiple
            pq.offer(newVal);
            sum += newVal; //update the sum with the new value

        }
        return true;
    }
}
// @lc code=end

