/*
 * @lc app=leetcode id=2208 lang=java
 *
 * [2208] Minimum Operations to Halve Array Sum
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq =  new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0;
        for(int num : nums){
            pq.offer(num * 1.0);
            sum += num;
        }
        int ans = 0;
        double target = sum / 2;
        while(sum > target){
            double max = pq.poll();
            sum -= max / 2;
            pq.offer(max / 2);
            ans++;
        }
        return ans;
    }
}
// @lc code=end

