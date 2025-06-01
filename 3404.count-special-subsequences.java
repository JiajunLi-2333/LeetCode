/*
 * @lc app=leetcode id=3404 lang=java
 *
 * [3404] Count Special Subsequences
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public long numberOfSubsequences(int[] nums) {
        //nums[a] * nums[c] == nums[b] * nums[d]
        // a < b < c < d
        //Equivalent to:
        //nums[a] / nums[b] == nums[d] / nums[c]
        long ans = 0;
        Map<Float, Integer> map = new HashMap<>();
        for(int c = 4; c < nums.length -2; c++){
            float b = nums[c - 2];

            //iterate over a
            for(int a = 0; a < c - 3; a++){
                map.merge(nums[a] / b, 1, Integer::sum);
            }

            float c_ = nums[c];
            for(int d = c + 2; d < nums.length; d++){
                ans += map.getOrDefault(nums[d] / c_, 0);
            }
        }
        return ans;
    }
}
// @lc code=end

