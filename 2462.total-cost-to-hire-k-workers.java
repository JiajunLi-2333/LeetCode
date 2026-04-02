/*
 * @lc app=leetcode id=2462 lang=java
 *
 * [2462] Total Cost to Hire K Workers
 */
import java.util.*;
// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        //two minHeap
        PriorityQueue<Integer> forward = new PriorityQueue<>();
        PriorityQueue<Integer> backward = new PriorityQueue<>();
        int n = costs.length, left = 0, right = n -1;
        long ans = 0;
        //! special case 2 * candidates >= n
        if(2 * candidates >= n){
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int cost : costs){minHeap.offer(cost);}
            long res = 0;
            while(k-- > 0){
                res += minHeap.poll();
            }
            return res;
        }


        //! General Case
        for(int i = 0; i < candidates; i++){
            forward.offer(costs[i]);left++;
            backward.offer(costs[n - i - 1]);right--;
        }

        while(k > 0){
            if(backward.isEmpty() || (!forward.isEmpty() && forward.peek() <= backward.peek())){
                ans += forward.poll();
                if(left <= right) forward.offer(costs[left++]);
            } else {
                ans += backward.poll();
                if(left <= right) backward.offer(costs[right--]);
            }
            k--;
        }
        return ans;
    }
}


// @lc code=start

// @lc code=end

