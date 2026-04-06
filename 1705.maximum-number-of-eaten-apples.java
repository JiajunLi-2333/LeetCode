/*
 * @lc app=leetcode id=1705 lang=java
 *
 * [1705] Maximum Number of Eaten Apples
 */
import java.util.*;
// @lc code=start
class Solution {
    public int eatenApples(int[] apples, int[] days) {
       int ans = 0;
       PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
       for(int i = 0; i < apples.length || !minHeap.isEmpty(); i++){
            while(!minHeap.isEmpty() && minHeap.peek()[0] == i){
                minHeap.poll();
            }
            if(i < apples.length && apples[i] > 0){
                minHeap.offer(new int[]{i + days[i], apples[i]});
            }
            if(!minHeap.isEmpty()){
                ans++;
                if(--minHeap.peek()[1] == 0){
                    minHeap.poll();
                }
            }
       }
       return ans;
    }    
}
// @lc code=end

