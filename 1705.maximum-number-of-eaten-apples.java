/*
 * @lc app=leetcode id=1705 lang=java
 *
 * [1705] Maximum Number of Eaten Apples
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length, ans = 0, day = 0, i = 0;
        while(i < n || !pq.isEmpty()){
            if(i < n && apples[i] > 0){
                pq.offer(new int[]{day + days[i], apples[i]});
            }
            while(!pq.isEmpty() && (pq.peek()[0] <= day || pq.peek()[1] <= 0)){
                pq.poll();
            }
            if(!pq.isEmpty()){
                int[] top = pq.poll();
                ans++;
                top[1]--;
                if(top[1] > 0){
                    pq.offer(top);
                }
            }
            day++;
            i++;
        }
        return ans; 
    }    
}
// @lc code=end

