/*
 * @lc app=leetcode id=1944 lang=java
 *
 * [1944] Number of Visible People in a Queue
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[heights.length];
        Arrays.fill(ans, 0);
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            while(!stack.isEmpty() && height > heights[stack.peek()] ){
                int index = stack.pop();
                ans[index]++; 
            }
            if(!stack.isEmpty()) ans[stack.peek()]++;
            stack.push(i);
        }
        return ans;     
    }
}
// @lc code=end

