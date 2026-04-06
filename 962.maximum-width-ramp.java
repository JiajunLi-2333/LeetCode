/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            } 
        }

        int ans = 0;
        for(int i = n -1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}
// @lc code=end

