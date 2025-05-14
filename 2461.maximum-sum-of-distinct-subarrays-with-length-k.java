/*
 * @lc app=leetcode id=2461 lang=java
 *
 * [2461] Maximum Sum of Distinct Subarrays With Length K
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            if(i < k -1){
                continue;
            }
            if (map.size() == k){
                result = Math.max(result, sum);
            }

            int out = nums[i - k + 1];
            int count = map.get(out);
            sum -= out;
            if(count > 1){
                map.put(out, count - 1);
            }
            else{
                map.remove(out);
            }

        }
        return result;
    }
}
// @lc code=end

