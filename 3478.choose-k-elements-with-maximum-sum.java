/*
 * @lc app=leetcode id=3478 lang=java
 *
 * [3478] Choose K Elements With Maximum Sum
 */
import java.util.*;
// @lc code=start
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        //TODO construct the sorted array
        int n = nums1.length;
        Integer[] sorted = new Integer[n];
        for(int i = 0; i < n;i++){
            sorted[i] = i;
        }
        Arrays.sort(sorted, (a,b) -> Integer.compare(nums1[a], nums1[b]));

        //TODO MinHeap with length n: 0 <= n <= k;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum  = 0;
        long[] ans = new long[n];

        for(int i = 0; i < n;){
            int start = i;
            while(i < n && nums1[sorted[i]] == nums1[sorted[start]]){
                ans[sorted[i]] = sum;
                i++;
            }
            for(int j = start; j < i; j++){
                minHeap.offer(nums2[sorted[j]]);
                sum += nums2[sorted[j]];
                if(minHeap.size() > k){
                    sum -= minHeap.poll();
                }
            }
        }
        return ans;
    }
}
// @lc code=end

