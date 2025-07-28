/*
 * @lc app=leetcode id=3478 lang=java
 *
 * [3478] Choose K Elements With Maximum Sum
 */
import java.util.PriorityQueue;
import java.util.Arrays;
// @lc code=start
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] triples = new int[nums1.length][3];

        //Form in the form of {num1, num2, index} for sorting
        for(int i = 0; i < nums1.length; i++){
            triples[i][0] = nums1[i];
            triples[i][1] = nums2[i];
            triples[i][2] = i;
        }
        Arrays.sort(triples, (a, b) -> a[0] - b[0]);
        long[] ans = new long[nums1.length];
        long sum = 0;

        for(int i = 0; i < nums1.length; i++){
            //avoid the duplicate elements
            int targetIndex = triples[i][2];
            if(i > 0 && triples[i][0] == triples[i - 1][0]){
                //If the current number is same as the previous one, we can only choose one of them
                ans[targetIndex] = ans[triples[i - 1][2]];
            }
            else{
                //Otherwise, we can choose the maximum sum from the previous elements
                ans[targetIndex] = sum;
            }
            int cur = triples[i][1];
            pq.offer(cur);
            sum += cur;
            if(pq.size() > k){
                sum -= pq.poll();
            }
        }
        return ans;
    }
}
// @lc code=end

