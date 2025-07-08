/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        //! how to calculate the area of the rectangle in the stack? --> stack is monotionically increasing from bottom to top (use this property to calculate the area)
        int n = heights.length, ans = 0; 
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // dummy to handle edge cases
        for(int i = 0; i <= n; i++){
            int h = i < n? heights[i] : -1; // append a zero height at the end to handle the last rectangle calculation
            while(stack.size() > 1 && h <= heights[stack.peek()]){
                int j = stack.pop(); //the index of the stack top element
                int height = heights[j]; //find the height of the rectangle
                //find the width of the rectangle
                int width = i - stack.peek() - 1; //the width is the distance
                ans = Math.max(ans, height * width); //calculate the area
            }
            stack.push(i); //push the current index onto the stack
        }
        return ans;
        
    }
}
// @lc code=end

