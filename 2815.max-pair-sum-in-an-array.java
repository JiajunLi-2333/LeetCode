/*
 * @lc app=leetcode id=2815 lang=java
 *
 * [2815] Max Pair Sum in an Array
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int maxSum(int[] nums) {
        //clarification
        //Given integer array nums, we want the pairs that have the same largest digit -> the maximum sum

        //constriants
        //2 <= nums.length <= 100
        //1 <= nums[i] <= 10^4

        //edge case
        //Garantueed that there will be at least to numbers
        //nums = [10, 23] -> -1
        //nums = [17, 27, 88, 89, 67] -> 27 + 67

        //solution
        int[] map = new int[10];//notice: still need 10
        int ans = Integer.MIN_VALUE; 
        Arrays.fill(map, -1);
        for(int num : nums){
            int digit = Digit(num);
            if(map[digit] != -1){
                ans = Math.max(ans, num + map[digit]);
            }
            if(num > map[digit]){
                map[digit] = num;
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    private int Digit(int num){
        int ans = -1;
        while(num >= 10){
            ans = Math.max(ans, num % 10);
            num /= 10;
        }
        ans = Math.max(ans, num);
        return ans;
    }
  
}
// @lc code=end

