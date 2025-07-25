/*
 * @lc app=leetcode id=3296 lang=java
 *
 * [3296] Minimum Number of Seconds to Make Mountain Height Zero
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        // for(int time: workerTimes){
        //     pq.offer(new long[] {time, time, time});
        // }
        // long ans = 0;
        // while(mountainHeight-- > 0){
        //     long[] choice = pq.poll();
        //     long nextTime = choice[0], currentTime = choice[1], originalTime = choice[2];
        //     ans = nextTime;
        //     pq.offer(new long[] {nextTime + currentTime + originalTime, currentTime + originalTime, originalTime});
        // }
        // return ans;

        //! Use binary search to find the minimum time which is also doable 

    }
}
// @lc code=end

