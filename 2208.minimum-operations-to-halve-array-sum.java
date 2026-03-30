/*
 * @lc app=leetcode id=2208 lang=java
 *
 * [2208] Minimum Operations to Halve Array Sum
 */
import java.util.*;
// @lc code=start
class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0, ans = 0;
        for(int num : nums){sum += num; maxHeap.offer((double) num);}
        double half = (double) sum / 2;
        while(half > 0){
            double num = maxHeap.poll();
            half -= num / 2;
            ans++;
            maxHeap.offer(num/2);
        }
        return (int) ans; 
    }
}
// @lc code=end

