/*
 * @lc app=leetcode id=2558 lang=java
 *
 * [2558] Take Gifts From the Richest Pile
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for(int gift : gifts){
            queue.offer(gift);
        }
        long total = 0;
        for(int i = 0; i < k; i++){
            int maxGift = queue.poll();
            int reducedGift = (int) Math.sqrt(maxGift);
            queue.offer(reducedGift);
        }
        while(!queue.isEmpty()){
            total += queue.poll();
        }
        return total;

    }
}
// @lc code=end

