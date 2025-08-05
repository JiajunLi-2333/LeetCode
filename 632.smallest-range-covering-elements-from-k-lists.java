/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //Question Exploring needs to be strengthened
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int rightEnd = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            int x = nums.get(i).get(0);
            pq.offer(new int[]{x, i, 0});
            rightEnd = Math.max(x, rightEnd);
        }

        int ansLeft = pq.peek()[0];
        int ansRight = rightEnd;

        while(pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()){
            int[] top = pq.poll();
            top[0] = nums.get(top[1]).get(++top[2]);
            rightEnd = Math.max(rightEnd, top[0]);
            pq.offer(top);
            int left = pq.peek()[0];
            if(rightEnd - left  < ansRight - ansLeft){
                ansLeft = left;
                ansRight = rightEnd;
            }

        }
        return new int[]{ansLeft, ansRight};
    }
}
// @lc code=end

