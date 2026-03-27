/*
 * @lc app=leetcode id=3113 lang=java
 *
 * [3113] Find the Number of Subarrays Where Boundary Elements Are Maximum
 */
import java.util.*;
// @lc code=start
class Solution {
    public long numberOfSubarrays(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        //单调栈
        Deque<int[]> stack = new ArrayDeque<>();
        long ans = 0;
        for(int num : nums){
            while(!stack.isEmpty() && stack.peek()[0] < num){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek()[0] == num){
                int[] top = stack.pop();
                ans += top[1];
                top[1]++;
                stack.push(top);
            }
            else{
                stack.push(new int[]{num, 1});
            }
        }
        ans += nums.length;
        return ans;
    
    }
}
// @lc code=end
