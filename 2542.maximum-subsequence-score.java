/*
 * @lc app=leetcode id=2542 lang=java
 *
 * [2542] Maximum Subsequence Score
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        //子序列： 从无序 => 转换为有序
        //枚举最小nums2 不断更新 获得最大值
        int n = nums1.length;
        Integer[] index = new Integer[n];

        for(int i = 0; i < n; i++){
            index[i] = i;
        }

        Arrays.sort(index, (i, j) -> nums2[j] - nums2[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums1[index[i]];
            pq.offer(nums1[index[i]]);
        }

        long ans = sum * nums2[index[k-1]];
        for(int i = k; i < n; i++){
            int x = nums1[index[i]];
            if(x > pq.peek()){
                sum += x - pq.poll();
                pq.offer(x);
                ans = Math.max(ans, sum * nums2[index[i]]);
            }
        }
        return ans;
    }
}
// @lc code=end

