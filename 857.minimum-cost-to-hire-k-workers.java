/*
 * @lc app=leetcode id=857 lang=java
 *
 * [857] Minimum Cost to Hire K Workers
 */
import java.util.*;
// @lc code=start
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
       int n = quality.length;
       Integer[] idx = new Integer[n];
       Arrays.setAll(idx, i -> i);
       Arrays.sort(idx, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);

       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a);

       int sumQuality = 0;
       for(int i = 0; i < k; i++){
            maxHeap.offer(quality[idx[i]]);
            sumQuality += quality[idx[i]];
       }
       double ans = sumQuality * ((double) wage[idx[k - 1]] / quality[idx[k - 1]]);
       for(int i = k; i < n; i++){
            int q = quality[idx[i]];
            if(q < maxHeap.peek()){
                sumQuality -= maxHeap.poll() - q;
                maxHeap.offer(q);
                ans = Math.min(ans, sumQuality * ((double) wage[idx[i]] / q));
            }
       }
       return ans;
    }
}
// @lc code=end

