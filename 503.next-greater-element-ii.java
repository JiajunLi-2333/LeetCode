/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < 2 * n; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                ans[stack.pop()] = num;
            }
            stack.push(i % n);
        }
        return ans;
    }
}
// @lc code=end

