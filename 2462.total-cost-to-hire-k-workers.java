/*
 * @lc app=leetcode id=2462 lang=java
 *
 * [2462] Total Cost to Hire K Workers
 */
<<<<<<< HEAD
import java.util.Arrays;
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        //This question can be solved using two min-heaps
        int n = costs.length;
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();
        long ans = 0;
        //! Important Edge Case
        if(candidates * 2 + k > n){
            Arrays.sort(costs);
            for(int i = 0; i < k; i++){
                ans += costs[i];
            }
            return ans;
        }

        //populate the heaps with candidates
        for(int i = 0; i < candidates; i++){
            front.offer(costs[i]);
            back.offer(costs[n-1-i]);
        }

        int frontIndex = candidates;
        int backIndex = n - candidates - 1;
        while(k-- > 0){
            if(front.peek() <= back.peek()){
                ans += front.poll();
                front.offer(costs[frontIndex++]);
            }
            else{
                ans += back.poll();
                back.offer(costs[backIndex--]);
            }
        }
        return ans;



=======

// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
>>>>>>> b833881 (Nothing)
        
    }
}
// @lc code=end

