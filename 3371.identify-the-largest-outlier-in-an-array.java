/*
 * @lc app=leetcode id=3371 lang=java
 *
 * [3371] Identify the Largest Outlier in an Array
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int num : nums){
            map.merge(num, 1, Integer :: sum );
            sum += num;
        } 

        for (int num : nums){
            int outlier = sum - 2 * num;
            // If the outlier is equal to the current number and it appears only once, we can skip it
            if (outlier == num && map.get(num) == 1) {
                continue; 
            }
            if(map.containsKey(outlier) && map.get(outlier) > 0){
                ans = Math.max(ans, outlier);
            }

        }
        return ans;

    }
}
// @lc code=end

