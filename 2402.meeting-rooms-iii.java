/*
 * @lc app=leetcode id=2402 lang=java
 *
 * [2402] Meeting Rooms III
 */
import java.util.*; 
// @lc code=start
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0; i < n; i++){free.offer(i);}

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );

        int[] cnt = new int[n];

        for(int[] meeting : meetings){
            long start = meeting[0], end = meeting[1];
            while(!busy.isEmpty() && busy.peek()[0] <= start){
                free.offer((int) busy.poll()[1]);
            }
            if(!free.isEmpty()){
                int room = free.poll();
                busy.offer(new long[]{end, room});
                cnt[room]++;
            }else{
                long[] top = busy.poll();
                long newEnd = top[0] + end - start;
                int room = (int) top[1];
                cnt[room]++;
                busy.offer(new long[]{newEnd, room});

            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(cnt[i] > cnt[ans]){
                ans = i;
            }
        }
        return ans;
    }
}

// @lc code=end

