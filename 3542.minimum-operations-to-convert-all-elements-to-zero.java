/*
 * @lc app=leetcode id=3542 lang=java
 *
 * [3542] Minimum Operations to Convert All Elements to Zero
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int top = -1;
        for(int x : nums){
            while(top >= 0 && x < nums[top]){
                top--;
                ans++;
            }

            if(top < 0 || x != nums[top]){
                nums[++top] = x;
            }
        }
        return ans + top + (nums[0] > 0 ? 1 : 0);

    }
}
// @lc code=end

