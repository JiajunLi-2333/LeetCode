/*
 * @lc app=leetcode id=1944 lang=java
 *
 * [1944] Number of Visible People in a Queue
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n]; 
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                ans[stack.pop()]++;
            }
            if(!stack.isEmpty()){
                ans[stack.peek()]++;
            }
            stack.push(i);
            
        }
        return ans;
        
    }
}
// @lc code=end

