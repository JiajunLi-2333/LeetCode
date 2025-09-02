/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //! method One using priorityQueue
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // int rightEnd = Integer.MIN_VALUE;
        // for(int i = 0; i < nums.size(); i++){
        //     int x = nums.get(i).get(0);
        //     pq.offer(new int[]{x, i, 0});
        //     rightEnd = Math.max(x, rightEnd);
        // }

        // int ansLeft = pq.peek()[0];
        // int ansRight = rightEnd;

        // while(pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()){
        //     int[] top = pq.poll();
        //     top[0] = nums.get(top[1]).get(++top[2]);
        //     rightEnd = Math.max(rightEnd, top[0]);
        //     pq.offer(top);
        //     int left = pq.peek()[0];
        //     if(rightEnd - left  < ansRight - ansLeft){
        //         ansLeft = left;
        //         ansRight = rightEnd;
        //     }

        // }
        // return new int[]{ansLeft, ansRight};

        //! method 2 using sliding window
        int sumLen = 0;
        for (List<Integer> list : nums) {
            sumLen += list.size();
        }

        int[][] pairs = new int[sumLen][2];
        int pi = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int x : nums.get(i)) {
                pairs[pi][0] = x;
                pairs[pi++][1] = i;
            }
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int ansL = pairs[0][0];
        int ansR = pairs[sumLen - 1][0];
        int empty = nums.size();
        int[] cnt = new int[empty];
        int left = 0;
        for (int[] p : pairs) {
            int r = p[0];
            int i = p[1];
            if (cnt[i] == 0) { // 包含 nums[i] 的数字
                empty--;
            }
            cnt[i]++;
            while (empty == 0) { // 每个列表都至少包含一个数
                int l = pairs[left][0];
                if (r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
                i = pairs[left][1];
                cnt[i]--;
                if (cnt[i] == 0) { // 不包含 nums[i] 的数字
                    empty++;
                }
                left++;
            }
        }
        return new int[]{ansL, ansR};



    }
}
// @lc code=end

