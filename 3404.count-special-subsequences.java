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
        //! 把乱序关系变成顺位继承关系就可以用伏笔的方式解决问题
            
        //nums[a] / nums[b] == nums[d] / nums[c]
        long ans = 0;
        Map<Float, Integer> map = new HashMap<>();
        // for(int c = 4; c < nums.length -2; c++){
        //     float b = nums[c - 2];

        //     //iterate over a
        //     for(int a = 0; a < c - 3; a++){
        //         map.merge(nums[a] / b, 1, Integer::sum);
        //     }

        //     float c_ = nums[c];
        //     for(int d = c + 2; d < nums.length; d++){
        //         ans += map.getOrDefault(nums[d] / c_, 0);
        //     }
        // }
        // return ans;
        map.put( nums[0] / (float) nums[1], 1); // Initialize map with the first pair
        for(int c = 2; c < nums.length -1; c++){
            for(int d = c + 1; d < nums.length; d++){
                // Check if the ratio exists in the map
                float ratio = nums[d] / (float) nums[c];
                ans += map.getOrDefault(ratio, 0);
            }
            // Update the map with new pairs for the next iteration
            for(int a = 0; a < c - 1; a++){
                float ratio = nums[a] / (float) nums[c];
                map.merge(ratio, 1, Integer::sum);
            }

        }
        return ans;
    }
}
// @lc code=end

