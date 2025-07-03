/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i < n * 2; i++){
            int idx = i % n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[idx]){
                int top = stack.pop();
                ans[top] = nums[idx];
            }
            if(i < n) stack.push(idx);// Only push the index for the first n elements the other half is just to simulate the circular array
        }
        return ans;
    }
}
// @lc code=end

