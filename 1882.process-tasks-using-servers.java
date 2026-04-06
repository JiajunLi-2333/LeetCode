/*
 * @lc app=leetcode id=1882 lang=java
 *
 * [1882] Process Tasks Using Servers
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        
        //? available minHeap (weight. index)
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        //? unavailable minHeap (freeTime, weight, index)
        PriorityQueue<int[]> unavailable = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        for(int i = 0; i < n; i++){
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        int t = 0;
        for(int j = 0; j < m ;j++){
            t = Math.max(t, j);
            if(available.isEmpty()){
                t = Math.max(t, unavailable.peek()[0]);
            }
            while(!unavailable.isEmpty() && t >= unavailable.peek()[0]){
                int[] s = unavailable.poll();
                available.offer(new int[]{s[1], s[2]});
            }

            int[] assign = available.poll();
            ans[j] = assign[1];
            unavailable.offer(new int[]{t + tasks[j], assign[0], assign[1]});
        }
        return ans;
    }
}
// @lc code=end
