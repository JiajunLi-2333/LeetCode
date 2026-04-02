/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(tasks[a][0], tasks[b][0]));

        // [processingTime, originalIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        int[] ans = new int[n];
        int ansIdx = 0;
        int i = 0;          // 指向 sorted tasks
        long time = 0;      // 当前时间

        while (ansIdx < n) {
            // 把所有 enqueueTime <= time 的任务入堆
            while (i < n && tasks[idx[i]][0] <= time) {
                pq.offer(new int[]{tasks[idx[i]][1], idx[i]});
                i++;
            }

            if (pq.isEmpty()) {
                // 堆空但还有任务没到，直接跳到下一个任务的到达时间
                time = tasks[idx[i]][0];
                continue;
            }

            int[] cur = pq.poll();
            ans[ansIdx++] = cur[1];
            time += cur[0];
        }

        return ans;
    }
}
// @lc code=end

