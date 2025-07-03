/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        // Logically it is correct but it exceeds the time limit
        // int n = nums.length;
        // if(nums.length < 3)
        //     return false;
        // int min = nums[0];
        // for(int i=0;i<n;i++){
        //     min = Math.min(min,nums[i]); // 找到最小值即1
        //     if(min == nums[i])// 若最小值为当前值则进行下一次遍历
        //         continue;
        //     for(int j=n-1;j>i;j--)
        //     {
        //         if(min < nums[j] && nums[j] < nums[i]) //若出现32则返回正确
        //             return true;
        //     }
        // }
        // return false;
        //! Iterate i, update k, and check if we can find a j

        //The Stack is used to keep track of the potential 3's in the 132 pattern. Once we find nums[k] > nums[i] we can return true
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int k = Integer.MIN_VALUE; //
        for(int i = n -1; i >= 0; i--){
            if(nums[i] < k){
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                int top = stack.pop();
                k = top;
            }
            stack.push(nums[i]);
        }
        return false;


    }
}
// @lc code=end

