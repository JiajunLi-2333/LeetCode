/*
 * @lc app=leetcode id=2406 lang=java
 *
 * [2406] Divide Intervals Into Minimum Number of Groups
 */
import java.util.Arrays;
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek() < interval[0]){
                pq.poll(); // Remove the group that ends before the current interval starts
            }
            pq.offer(interval[1]); // Add the current interval's end time to the group
        }
        return pq.size();
    }
}
// @lc code=end

