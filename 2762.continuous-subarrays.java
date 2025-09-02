/*
 * @lc app=leetcode id=2762 lang=java
 *
 * [2762] Continuous Subarrays
 */
import java.util.*;
// @lc code=start
class Solution {
    public long continuousSubarrays(int[] nums) {
        //使用两个单调队列来维护滑窗内部的最大值和最小值 同时方便滑窗更新

        //最重要的是题目条件等价于维护窗口内最大值和最小值的差值小于等于2
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        long ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.pollLast();
            }
            minQ.offerLast(nums[right]);
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(nums[right]);
            while (maxQ.peekFirst() - minQ.peekFirst() > 2) {
                if (minQ.peekFirst() == nums[left]) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() == nums[left]) {
                    maxQ.pollFirst();
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;

    }
}
// @lc code=end

