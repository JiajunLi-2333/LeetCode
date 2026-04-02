/*
 * @lc app=leetcode id=1792 lang=java
 *
 * [1792] Maximum Average Pass Ratio
 */
import java.util.*;
// @lc code=start
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0, n = classes.length;
        //? [increase amount to result, class index]
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0],a[0]));
        int i = 0;
        for(int[] room : classes){
            double pass = room[0];
            double total = room[1];
            double[] insert = new double[]{(total - pass)/(total * (total + 1)), i++};
            maxHeap.offer(insert);
        }
        while(extraStudents-- > 0){
            double[] top = maxHeap.poll();
            int index = (int) top[1];
            classes[index][0]++;
            classes[index][1]++;
            double pass = classes[index][0];
            double total = classes[index][1];
            maxHeap.offer(new double[]{(total - pass)/(total * (total + 1)), index});
        }
        for(int[] room : classes){
            ans += (double) room[0] / room[1];
        }
        return ans/n;
    }
}
// @lc code=end

