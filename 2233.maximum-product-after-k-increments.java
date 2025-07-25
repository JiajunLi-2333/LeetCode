/*
 * @lc app=leetcode id=2233 lang=java
 *
 * [2233] Maximum Product After K Increments
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }
        for(int i = 0; i < k; i++){
            int min = minHeap.poll();
            min++;
            minHeap.offer(min);
        }
        long product = 1;
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % 1000000007;
        }
        return (int) product;
    }
}
// @lc code=end

