/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */
import java.util.*;
// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(list,(a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        while(k-- > 0){
            while(i < n && list.get(i)[0] <= w) maxHeap.offer(list.get(i++)[1]);
            if(maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;

    }
}
// @lc code=end

