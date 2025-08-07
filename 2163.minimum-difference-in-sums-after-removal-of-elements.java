/*
 * @lc app=leetcode id=2163 lang=java
 *
 * [2163] Minimum Difference in Sums After Removal of Elements
 */
import java.util.*;
// @lc code=start
class Solution {
    public long minimumDifference(int[] nums) {
        //贪心策略 + 枚举策略
        //实现方式： 堆 + 预处理
        //堆的定义： 维护的是需要留下来的元素 
        //前后缀：便于在O(1)的事件完成差值的计算
        int m = nums.length;
        int n = m / 3; //This is the base

        //计算后缀
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        long sum = 0;
        for(int i = m -1; i >= m-n; i--){
            minPQ.offer(nums[i]);
            sum += nums[i];
        }

        long[] sufMax = new long[m-n + 1]; //后缀最大和
        sufMax[m-n] = sum;
        for(int i = m-n-1; i >= n; i--){
            int cur = nums[i];
            if(cur > minPQ.peek()){
                sum += cur - minPQ.poll();
                minPQ.offer(cur);
            }
            sufMax[i] = sum;
        }

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        long preMin = 0;
        for(int i = 0; i < n; i++){
            maxPQ.offer(nums[i]);
            preMin += nums[i];
        }

        long ans = preMin - sufMax[n]; //初始值
        for(int i = n; i < m-n; i++){
            int cur = nums[i];
            if(cur < maxPQ.peek()){
                preMin += cur - maxPQ.poll();
                maxPQ.offer(cur);
            }
            ans = Math.min(ans, preMin - sufMax[i + 1]);
        }
        return ans;



        
    }
}
// @lc code=end

