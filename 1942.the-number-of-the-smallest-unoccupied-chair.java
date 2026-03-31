/*
 * @lc app=leetcode id=1942 lang=java
 *
 * [1942] The Number of the Smallest Unoccupied Chair
 */

import java.util.*;
// @lc code=start
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;   

        Integer[] sorted = new Integer[n];
        for(int i = 0; i < n; i++){
            sorted[i] = i;
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(times[a][0], times[b][0]));


        PriorityQueue<Integer> available = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            available.offer(i);
        }

        //[leaving time, seat index number]
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i : sorted){
            int arrival = times[i][0];
            int leave = times[i][1];
            
            while(!occupied.isEmpty() && occupied.peek()[0] <= arrival){
                int[] top = occupied.poll();
                available.offer(top[1]);
            }
            
            int seat = available.poll();
            if(i == targetFriend) return seat;
            occupied.offer(new int[]{leave, seat});
        }
        return -1;
    }
}
// @lc code=end

