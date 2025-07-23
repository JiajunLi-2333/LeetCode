/*
 * @lc app=leetcode id=3066 lang=java
 *
 * [3066] Minimum Operations to Exceed Threshold Value II
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer((long) num);
        }
        int ans = 0;
        while(pq.peek() < k && pq.size() > 1){
            long x = pq.poll(), y = pq.poll();
            pq.offer(transform(x,y));
            ans++;
        }
        return ans;

        
    }
    private long transform(long x, long y){
        return Math.min(x,y) * 2 + Math.max(x,y);
    }
}
// @lc code=end

