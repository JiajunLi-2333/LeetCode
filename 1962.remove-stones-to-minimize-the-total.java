/*
 * @lc app=leetcode id=1962 lang=java
 *
 * [1962] Remove Stones to Minimize the Total
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int minStoneSum(int[] piles, int k) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            pq.offer(pile);
        }
        while(k-- > 0 && !pq.isEmpty()){
            int max = pq.poll();
            int reduced = (int) Math.ceil(max / 2.0);
            pq.offer(reduced);
        }
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}
// @lc code=end

