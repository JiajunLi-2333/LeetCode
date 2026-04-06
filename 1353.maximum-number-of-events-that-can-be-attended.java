/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
       int maxDate = 0, ans = 0;
       for(int[] event : events){
            maxDate = Math.max(maxDate, event[1]);
       }

       List<Integer>[] list = new ArrayList[maxDate + 1];
       Arrays.setAll(list, i -> new ArrayList<Integer>());
       for(int[] event : events){
            list[event[0]].add(event[1]);
       }

       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

       for(int d = 0; d <= maxDate; d++){
            while(!minHeap.isEmpty() && minHeap.peek() < d){
                minHeap.poll();
            }
            for(int enddate : list[d]){
                minHeap.add(enddate);
            }
            if(!minHeap.isEmpty()){
                minHeap.poll();
                ans++;
            }
       }
       return ans;
    }
}
// @lc code=end

