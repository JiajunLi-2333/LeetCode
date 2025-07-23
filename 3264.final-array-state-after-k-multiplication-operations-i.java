/*
 * @lc app=leetcode id=3264 lang=java
 *
 * [3264] Final Array State After K Multiplication Operations I
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue =
    new PriorityQueue<>((a, b) -> {
        int cmp = Integer.compare(a[0], b[0]);
        if (cmp != 0) return cmp;
        return Integer.compare(a[1], b[1]);
    });
        for(int i = 0; i < nums.length; i++){
            queue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length];
        while(k > 0){
            int[] cur = queue.poll();
            queue.offer(new int[]{cur[0] * multiplier, cur[1]});
            k--;
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            ans[cur[1]] = cur[0];
        }
        return ans;
    }
}
// @lc code=end

