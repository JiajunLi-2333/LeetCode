/*
 * @lc app=leetcode id=933 lang=java
 *
 * [933] Number of Recent Calls
 */
import java.util.Queue;
import java.util.LinkedList;
// @lc code=start
class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
        
    }
    
    public int ping(int t) {
        queue.offer(t);
        int queueTop = queue.peek();
        while(queueTop < t - 3000){
            queue.poll();
            queueTop = queue.peek();
        } 
        return queue.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

