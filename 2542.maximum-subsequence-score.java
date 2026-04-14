/*
 * @lc app=leetcode id=2542 lang=java
 *
 * [2542] Maximum Subsequence Score
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> nums2[b] - nums2[a]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long sum  = 0; long ans = 0;
        for(int i = 0; i < n; i++){
            int index = idx[i];
            minHeap.offer(nums1[index]);
            sum += nums1[index];

            if(minHeap.size() > k){
                sum -= minHeap.poll(); 
            }
            if(minHeap.size() == k){
                ans = Math.max(ans, sum * nums2[index]);
            }
        }
        return ans;


    }
}
// @lc code=end

