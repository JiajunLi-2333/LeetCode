/*
 * @lc app=leetcode id=1383 lang=java
 *
 * [1383] Maximum Performance of a Team
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long MOD = (long) 1e9 + 7;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> efficiency[b] - efficiency[a]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            int j = idx[i];
            pq.offer(speed[j]);
            sum += speed[j];

            if (pq.size() > k) {
                sum -= pq.poll();
            }
            // 不需要 pq.size() == k 的限制，随时都可以更新
            ans = Math.max(ans, sum * efficiency[j]);
        }
        return (int) (ans % MOD);
    }
}
// @lc code=end

