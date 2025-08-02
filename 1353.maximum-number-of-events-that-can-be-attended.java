/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
        int maxDate = 0;
        for(int[] event: events){
            maxDate = Math.max(maxDate, event[1]);
        }

        List<Integer>[] groups = new ArrayList[maxDate + 1];
        Arrays.setAll(groups, i -> new ArrayList<>());
        for(int[] event: events){
            groups[event[0]].add(event[1]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//strores the end dates of all available events

        int ans = 0;
        for(int i = 0; i <= maxDate; i++){
            while(!minHeap.isEmpty() && minHeap.peek() < i){
                minHeap.poll();
            }
            for(int endDate: groups[i]){
                minHeap.offer(endDate);
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

