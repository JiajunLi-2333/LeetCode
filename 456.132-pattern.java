/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        //clarification
        //(i,j,k) 
        // i  < j < k 有序 ordered
        // nums[j] is the greatest, nums[i] is the smallest and nums[k] is in between

        //constriant 
        // n == nums.length
        // 1 <= n <= 2 * 10^5
        // -10^9 <= nums[i] <= 10^9

        //edge case
        // n < 3 -> false
        // nums are increasing or decreasing -> false
        // nums have all the same numbers -> false

        //solution
        //intuitive: nested for loops

        int n = nums.length; 
        if(n < 3){
            return false;
        }
        int[] suf = new int[n];
        suf[0] = nums[0];

        for(int i = 1 ; i < n; i++){
            suf[i] = Math.min(suf[i - 1], nums[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>(); // monotonically decreasing stack

        for(int j = n - 1; j > 0; j--){
            while(!stack.isEmpty()&& stack.peek() <= suf[j - 1]){
                stack.pop();
            }
            if(!stack.isEmpty() && nums[j] > stack.peek()){
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }
}
// @lc code=end

