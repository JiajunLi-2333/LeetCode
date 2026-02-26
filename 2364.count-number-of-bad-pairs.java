/*
 * @lc app=leetcode id=2364 lang=java
 *
 * [2364] Count Number of Bad Pairs
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public long countBadPairs(int[] nums) {
       //clarification
       //count the number of bad paris, where a pair is
       // (i < j) && j - i != nums[j] - nums[i]

       //constraints
       //1 <= nums.length <= 10 ^ 5
       //1 <= nums[i] <= 10 ^ 9

       //edge case
       // nums = [1] -> 0
       // nums = [3,3,3,3,3] -> all pairs are bad paris
       // ans could be quite long

       //solution
       // nums[i] - i != nums[j] - j

       long ans = 0;
       Map<Integer, Integer> cnt = new HashMap<>();
       for(int j = 0; j < nums.length; j++){
            int val = nums[j] - j;
            int points = j - cnt.getOrDefault(val, 0);
            ans += points;
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
       }
       return ans;
    }
}
// @lc code=end

