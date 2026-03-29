/*
 * @lc app=leetcode id=1962 lang=java
 *
 * [1962] Remove Stones to Minimize the Total
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0;
        for(int num : piles){
            maxHeap.offer(num);
            ans += num;
        }
        for(int i = 0; i < k; i++){
            int val = maxHeap.poll();
            ans -= val/2; 
            maxHeap.offer(val - val / 2);
        }
        return ans;
    }
}
// @lc code=end

