/*
 * @lc app=leetcode id=2931 lang=java
 *
 * [2931] Maximum Spending After Buying Items
 */
import java.util.PriorityQueue;
import java.util.Arrays;
// @lc code=start
class Solution {
    public long maxSpending(int[][] values) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int[] value: values){
        //     for(int v: value){
        //         pq.offer(v);
        //     }
        // }
        // long days = values.length * values[0].length;
        // long ans = 0;
        // for(long i = 0; i < days; i++){
        //     ans += pq.poll() * (i + 1);
        // }
        // return ans;

        //! This ensures the logic of always taking the rightmost element but it is unnecessary because the arrays are sorted already in descending order.
        // int m = values.length;
        // int n = values[0].length;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> values[a[0]][a[1]] - values[b[0]][b[1]]);
        // for (int i = 0; i < m; i++) {
        //     pq.offer(new int[]{i, n - 1});
        // }

        // long ans = 0;
        // for (int d = 1; d <= m * n; d++) {
        //     int[] p = pq.poll();
        //     int i = p[0];
        //     int j = p[1];
        //     ans += (long) values[i][j] * d;
        //     if (j > 0) {
        //         pq.offer(new int[]{i, j - 1});
        //     }
        // }
        // return ans;

        int[] allValues = new int[values.length * values[0].length];
        int index = 0;
        for (int[] row : values) {
            for (int v : row) {
                allValues[index++] = v;
            }
        }
        Arrays.sort(allValues);
        long ans = 0;
        for (int d = 1; d <= allValues.length; d++) {
            ans += (long) allValues[d - 1] * d;
        }
        return ans;
    }
}
// @lc code=end

