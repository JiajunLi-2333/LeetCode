/*
 * @lc app=leetcode id=2406 lang=java
 *
 * [2406] Divide Intervals Into Minimum Number of Groups
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minGroups(int[][] intervals) {
        //sort the array according to left
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] interval : intervals){
            int left = interval[0], right = interval[1];
            if(!minHeap.isEmpty() && minHeap.peek() < left){
                minHeap.poll();
            }
            minHeap.offer(right);
        }
        return minHeap.size();
    }
}
// @lc code=end

