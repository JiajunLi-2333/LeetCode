/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */
import java.util.PriorityQueue;
// @lc code=start
class KthLargest {
    private final int limit;
    private final PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        limit = k;
        pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > limit) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > limit) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

