/*
 * @lc app=leetcode id=3275 lang=java
 *
 * [3275] K-th Nearest Obstacle Queries
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); // Max-heap to keep track of the k-th largest distances
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int x  = queries[i][0], y = queries[i][1];
            int dis = Distance(x,y);
            pq.offer(dis);
            if(pq.size() > k){
                pq.poll();
            }
            if(pq.size() == k){
                ans[i] = pq.peek();
            } else {
                ans[i] = -1; // If there are less than k obstacles, return -1
            }
        }
        return ans;
    }
    private int Distance(int x, int y){
        return Math.abs(x) + Math.abs(y);
    }
}
// @lc code=end

