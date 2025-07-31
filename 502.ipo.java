/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
// @lc code=start
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> projects =  new ArrayList<>();
        for(int i = 0; i < profits.length; i++){
            projects.add(new int[] {capital[i], profits[i]});
        }
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
        projects.sort((a, b) -> a[0] - b[0]); // Sort by capital required
        int i = 0;
        while(k-- > 0) {
            while (i < projects.size() && projects.get(i)[0] <= w) {
                maxProfitHeap.offer(projects.get(i)[1]);
                i++;
            }
            if(maxProfitHeap.isEmpty()) {
                break; // No more projects can be funded to avoid cases where k > number of projects
            }
            w += maxProfitHeap.poll(); // Add the maximum profit project to the capital
        }
        return w;
    }
}
// @lc code=end

