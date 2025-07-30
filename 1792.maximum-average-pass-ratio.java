/*
 * @lc app=leetcode id=1792 lang=java
 *
 * [1792] Maximum Average Pass Ratio
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    /**
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // The key is about the maximum increase in average pass ratio by adding one student to the class
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double diffA = increaseAmount(a);
            double diffB = increaseAmount(b);
            return Double.compare(diffB, diffA);
        });
        for(int[] cls : classes){
            pq.offer(cls);
        }
        while(extraStudents-- > 0){
            int[] cls = pq.poll();
            cls[0]++; 
            cls[1]++; 
            pq.offer(cls); 
        }
        double ans = 0;
        while(!pq.isEmpty()){
            int[] cls = pq.poll();
            ans += (double) cls[0] / cls[1]; 
        }
        return ans / classes.length; 
    }
    private double increaseAmount(int[] cls){
        int x = cls[0];
        int y = cls[1];
        return (double) (x + 1) / (y + 1) - (double) x / y;
    }
}
// @lc code=end

