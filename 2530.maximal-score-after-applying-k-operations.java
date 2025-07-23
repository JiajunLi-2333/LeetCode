/*
 * @lc app=leetcode id=2530 lang=java
 *
 * [2530] Maximal Score After Applying K Operations
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums){
            pq.offer(num);
        } 
        long score = 0;
        while(k-- > 0){
            int max = pq.poll();
            score += max;
            pq.offer((int) Math.ceil(max / 3.0));
        }
        return score;
    }
}
// @lc code=end

