/*
 * @lc app=leetcode id=2163 lang=java
 *
 * [2163] Minimum Difference in Sums After Removal of Elements
 */
import java.util.*;
class Solution {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;

        //minHeap for the sum_second
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum =  0;
        for(int i = m - 1 ; i >= m - n; i--){
            minHeap.offer(nums[i]);
            sum += nums[i];
        }
        long[] sufMax = new long[m -n + 1];
        sufMax[m - n] = sum;
        for(int i = m - n -1; i >= n; i--){
            int num = nums[i];
            if(num > minHeap.peek()){
                sum += num - minHeap.poll();
                minHeap.offer(num);
            }
            sufMax[i] = sum;
        }

        //maxHeap for sum_first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a);
        long preMin = 0;
        for(int i = 0; i < n; i++){
            maxHeap.offer(nums[i]);
            preMin += nums[i];
        }
        long ans = preMin - sufMax[n];
        for(int i = n ; i < m - n; i++){
            int num = nums[i];
            if(num < maxHeap.peek()){
                preMin += num - maxHeap.poll();
                maxHeap.offer(num);
            }
            ans = Math.min(ans, preMin - sufMax[i + 1]);            
        }
        return ans;
    }
}
// @lc code=end

