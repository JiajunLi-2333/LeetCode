/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */
import java.util.PriorityQueue;
import java.util.Arrays;
// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        //use priority queue to schedule tasks and simulate the CPU processing
        int n = tasks.length;
        int[][] indexedTasks = new int[n][3];
        for(int i = 0; i < n; i++){
            indexedTasks[i][0] = tasks[i][0]; // enqueue time
            indexedTasks[i][1] = tasks[i][1]; // processing time
            indexedTasks[i][2] = i; // original index
        }

        //Sort tasks by enqueue time
        Arrays.sort(indexedTasks, (a, b) -> a[0] - b[0]);
        //Store processing time and original index in a priority queue
        //store accroding to the processing time, if processing time is same, then store according to the original index  Min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1]; // if processing time is same, sort by original index
            }
            return a[0] - b[0]; // sort by processing time
        });

        int[] ans = new int[n];
        int time = indexedTasks[0][0]; // start time
        
        int i = 0, j = 0;

        //! very important logic loop here
        while(i < n){
            while(j < n && indexedTasks[j][0] <= time){
                pq.offer(new int[]{indexedTasks[j][1], indexedTasks[j][2]});
                j++;
            }
            if(pq.isEmpty()){
                time = indexedTasks[j][0];
            }else{
                int[] curr = pq.poll();
                ans[i++] = curr[1];
                time += curr[0];
            }
        }

        return ans;
    }
}
// @lc code=end

