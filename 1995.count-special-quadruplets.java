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
    // nums[a] + nums[b] + nums[c] == nums[d]
    // nums[a] + nums[b] == nums[d] - nums[c]
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for(int c = 0; c < n; c++){
        for(int d = c + 1; d < n; d++){
            int sum = nums[d] - nums[c];
            if(map.containsKey(sum)){
                ans += map.get(sum);
            }
        }
        for(int a = 0; a < c; a++){
            map.put(nums[a] + nums[c], map.getOrDefault(nums[a] + nums[c], 0) + 1);
        }
    }
    return ans;
}
}
// @lc code=end

