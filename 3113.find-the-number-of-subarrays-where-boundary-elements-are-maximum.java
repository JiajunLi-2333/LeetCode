/*
 * @lc app=leetcode id=3113 lang=java
 *
 * [3113] Find the Number of Subarrays Where Boundary Elements Are Maximum
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public long numberOfSubarrays(int[] nums) {
        //! I think understand why monotonic stack is useful here but I forget to consider the case where the boundary elements may appear multiple times 

        int n = nums.length;
        long ans = n;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, -1}); // dummy element to simplify 
        for(int i = 0; i < n; i++){
            int x = nums[i];
            while(!stack.isEmpty() && stack.peek()[0] < x){
                stack.pop();
            }
            if(x == stack.peek()[0]){
                ans += stack.peek()[1]++; // add the number of subarrays ending at i with boundary elements equal to x
                
            }
            else{
                stack.push(new int[]{x, 1});
            }
        }
        return ans;
    }
}
// @lc code=end

