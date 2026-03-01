/*
 * @lc app=leetcode id=1995 lang=java
 *
 * [1995] Count Special Quadruplets
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int countQuadruplets(int[] nums) {
        // a < b  < c < d
        // We can use a brute force approach to check all combinations of quadruplets
    //     int count = 0;
    //     for (int a = 0; a < nums.length - 3; a++) {
    //         for (int b = a + 1; b < nums.length - 2; b++) {
    //             for (int c = b + 1; c < nums.length - 1; c++) {
    //                 for (int d = c + 1; d < nums.length; d++) {
    //                     if (nums[a] + nums[b] + nums[c] == nums[d]) {
    //                         count++;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }

    //todo Better Approach Reduce the variables
    //nums[a] + nums[b] = nums[d] - nums[c]
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0, n = nums.length; 
    for(int c = 2; c <= n - 2; c++){
        for(int a = 0; a < c -1; a++){
            map.merge(nums[a] + nums[c - 1], 1 ,Integer::sum);
        }
        for(int d = c + 1; d < n; d++){
            ans += map.getOrDefault(nums[d] - nums[c],0);
        }
    } 
    return ans;
}
}
// @lc code=end

