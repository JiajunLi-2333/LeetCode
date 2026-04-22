/*
 * @lc app=leetcode id=2940 lang=java
 *
 * [2940] Find Building Where Alice and Bob Can Meet
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        //! new algo thinking:离线算法
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        
        List<int[]>[] qs = new ArrayList[heights.length];
        Arrays.setAll(qs, i -> new ArrayList<>());
        
        for(int i = 0; i < queries.length;i++){
            int a = queries[i][0]; // denotes the position of alice
            int b = queries[i][1]; // denotes the position of bob

            if(a > b){
                int tmp = a;
                a = b;
                b = tmp; // switch position to ensure a <= b
            }
            if(a == b || heights[a] < heights[b]){
                ans[i] = b;
            }
            else{
                qs[b].add(new int[]{heights[a], i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < heights.length; i++){
            while(!minHeap.isEmpty() && minHeap.peek()[0] < heights[i]){
                ans[minHeap.poll()[1]] = i;
            }
            for(int[] q : qs[i]){
                minHeap.offer(q);
            }
        }
        return ans;
    }
}
// @lc code=end

