/*
 * @lc app=leetcode id=2841 lang=java
 *
 * [2841] Maximum Sum of Almost Unique Subarray
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long result = 0;
        long sum = 0;
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);

            if(i < k -1){
                continue;
            }

            if(map.size() >= m){
                result = Math.max(result, sum);
            }

            sum -= nums.get(i - k + 1);
            int count = map.get(nums.get(i - k + 1));
            if(count == 1){
                map.remove(nums.get(i - k + 1));
            } else {
                map.put(nums.get(i - k + 1), count - 1);
            }

        }
        return result;
    }
}
// @lc code=end

