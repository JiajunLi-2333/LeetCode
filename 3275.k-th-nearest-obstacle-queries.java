/*
 * @lc app=leetcode id=3275 lang=java
 *
 * [3275] K-th Nearest Obstacle Queries
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
       int n = queries.length;
       int[] ans = new int[n];
       Arrays.fill(ans, -1);
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a );
       for(int i = 0; i < n; i++){
        int[] query = queries[i];
        int dis = Math.abs(query[0]) + Math.abs(query[1]);
        maxHeap.offer(dis);
        if(maxHeap.size() > k){
            maxHeap.poll();
        }
        if(maxHeap.size() == k){
            ans[i] = maxHeap.peek();
        }
        
       }
       return ans;

    }
}
// @lc code=end

