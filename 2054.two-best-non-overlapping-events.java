/*
 * @lc app=leetcode id=2054 lang=java
 *
 * [2054] Two Best Non-Overlapping Events
 */
import java.util.*;
// @lc code=start

class Solution{
    public int maxTwoEvents(int[][] events){
        //左右指针的双线处理技巧
        //! 注意是“双线”
        int n = events.length;
        int[][] startSort = events.clone();
        int[][] endSort = events.clone();
        Arrays.sort(startSort, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(endSort, (a, b) -> Integer.compare(a[1], b[1]));
        
        int max = 0; 
        int ans = 0;
        int i = 0; 
        for(int[] event : startSort){
            int start = event[0], value = event[2];
            while(endSort[i][1] < start && i < n){
                max = Math.max(max, endSort[i][2]);
                i++;
            } 
            ans = Math.max(ans, max + value);
        }
        return ans;
        

    }
}



// class Solution {
//     public int maxTwoEvents(int[][] events) {
//         //minHeap + sort
//         Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

//         //minHeap endtime, value
//         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
//         int max = 0;// cannot be Integer.MIN_VALUE for a reason
//         int ans = 0; 
//         for(int[] event : events){
//             int start = event[0], end = event[1], value = event[2];
//             while(!minHeap.isEmpty() && minHeap.peek()[0] < start){
//                 max = Math.max(max, minHeap.poll()[1]);
//             }
//             ans = Math.max(ans, max + value);
//             minHeap.offer(new int[]{end, value});
//         }
//         return ans;

//     }
// }
// @lc code=end

