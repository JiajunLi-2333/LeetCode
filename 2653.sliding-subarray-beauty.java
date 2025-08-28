/*
 * @lc app=leetcode id=2653 lang=java
 *
 * [2653] Sliding Subarray Beauty
 */
import java.util.*;
// @lc code=start
class Solution {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;
    int[] location;
    int maxpqHave;
    int minpqHave;
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        minpq = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));
        maxpq = new PriorityQueue<>((a,b)-> nums[b] - nums[a]);
        location = new int[nums.length];// 0为删除 1在大堆 -1在小堆
        maxpqHave = 0; // 大堆有效元素
        minpqHave = 0; // 小堆有效元素

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 入窗口
            if (nums[i] < 0){
                maxpq.add(i);// 不管什么元素，只要符合条件(<0)先入大顶堆
                location[i] = 1;
                maxpqHave++;
            }
            if (i >= k && nums[i - k] < 0){
                //延迟删除
                if (location[i - k] < 0){
                    minpqHave--;
                }else {
                    maxpqHave--;
                }
                location[i - k] = 0; // 标记删除
            }
            if (i >= k - 1){
                ans[i - k + 1] = pqGet(x, nums);
            }
        }
        return ans;
    }

    private int pqGet(int x, int[] nums) {
        pqAdjust(nums);
        while (maxpqHave > x){
            pqRemove(maxpq);
            Integer poll = maxpq.poll();
            minpq.add(poll);
            maxpqHave--;
            minpqHave++;
            location[poll] = -1;
        }
        while (maxpqHave < x){
            pqRemove(minpq);
            if (minpqHave > 0){
                Integer poll = minpq.poll();
                maxpq.add(poll);
                maxpqHave++;
                minpqHave--;
                location[poll] = 1;
            }else if (maxpqHave < x){
                break;
            }
        }
        pqRemove(maxpq);
        if (maxpqHave == x){
            return nums[maxpq.peek()];
        }
        return 0;
    }
    private void pqAdjust(int[] nums) {
        while (maxpqHave > 0 && minpqHave > 0 && nums[maxpq.peek()] > nums[minpq.peek()]){
            pqRemove(maxpq);
            pqRemove(minpq);
            Integer poll = maxpq.poll();
            minpq.add(poll);
            location[poll] = -1;
            maxpqHave--;
            minpqHave++;
        }
    }

    private void pqRemove(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && location[pq.peek()] == 0){
            pq.poll();
        }
    }
}
// @lc code=end

