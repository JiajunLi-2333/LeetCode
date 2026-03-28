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

    //? answer to the modified google question
    // Deque<Integer> stack = new ArrayDeque<>();
    // int n = heights.length;
    // int[] ans = new int[n];
    // for(int i = n - 1; i >= 0; i--){
    //     int height = heights[i];
    //     while(!stack.isEmpty() && height > heights[stack.peek()]){
    //         stack.pop();
    //         ans[i]++;
    //     }
    //     ans[i] += stack.size();
    //     stack.push(i);
    // }
    // return ans;
}
// @lc code=end

