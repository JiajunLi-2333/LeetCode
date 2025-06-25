/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, ans = 0,n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int mod = (sum % k + k) % k; // to handle negative numbers
            if(map.containsKey(mod)){
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

