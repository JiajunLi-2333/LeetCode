/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */
import java.util.*;
// @lc code=start
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> works = new ArrayList<>();
        for(int i = 0; i < n; i++){
            works.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        Collections.sort(works, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] w : works) {
            int s = w[0], e = w[1], v = w[2];
            // 在 time ≤ s 的所有状态中，找出最大的累计收益
            int tv = 0;
            while (!heap.isEmpty() && heap.peek()[0] <= s) {
                tv = Math.max(tv, heap.poll()[1]);
            }
            // 把两种新的状态压入堆中：
            // 1) 在 time = s 的时候，能获得 tv
            // 2) 在 time = e 的时候，能获得 tv + v
            heap.offer(new int[]{s, tv});
            heap.offer(new int[]{e, tv + v});

            // 更新答案：尽可能取最大
            ans = Math.max(ans, tv + v);
        }
        return ans;
    }
}
// @lc code=end

