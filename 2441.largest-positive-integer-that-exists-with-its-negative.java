/*
 * @lc app=leetcode id=2441 lang=java
 *
 * [2441] Largest Positive Integer That Exists With Its Negative
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int findMaxK(int[] nums) {
        //! A very stupid method
        // Set<Integer> set = new HashSet<>();
        // int max = -1;
        // for(int num: nums){
        //     set.add(num);
        //     if(set.contains(-num) && num > 0){
        //         max = Math.max(max, num);
        //     }
        //     if(set.contains(-num) && num < 0){
        //         max = Math.max(max, -num);
        //     }
        // }
        // return max;

        //todo An optimized method
        // Set<Integer> set = new HashSet<>();
        // int ans = -1;
        // for(int num: nums){
        //     if (set.contains(-num)){
        //         ans = Math.max(ans, Math.abs(num));
        //     }
        //     set.add(num);
        // }
        // return ans;
        Set<Integer> set = new HashSet<>();
        int ans =1
    }
}
// @lc code=end

