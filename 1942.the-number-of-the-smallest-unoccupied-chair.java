/*
 * @lc app=leetcode id=1942 lang=java
 *
 * [1942] The Number of the Smallest Unoccupied Chair
 */

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
// @lc code=start
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        //! 只能放在同一时间线上去进行事件标记
        // Create events for arrivals and departures
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            events.add(new int[]{times[i][0], 1, i}); // arrival: time, type=1, friend_id
            events.add(new int[]{times[i][1], 0, i}); // departure: time, type=0, friend_id
        }
        
        // Sort events: first by time, then departures before arrivals
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // 0 (departure) comes before 1 (arrival)
        });
        
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableChairs.offer(i);
        }
        
        int[] friendToChair = new int[times.length];
        
        for (int[] event : events) {
            int type = event[1];
            int friendId = event[2];
            
            if (type == 0) { // departure
                availableChairs.offer(friendToChair[friendId]);
            } else { // arrival
                int chair = availableChairs.poll();
                friendToChair[friendId] = chair;
                
                // If this is our target friend, return the chair
                if (friendId == targetFriend) {
                    return chair;
                }
            }
        }
        
        return -1; // Should never reach here
    }
}
// @lc code=end

