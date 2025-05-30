/*
 * @lc app=leetcode id=1814 lang=java
 *
 * [1814] Count Nice Pairs in an Array
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int countNicePairs(int[] nums) {
        //i < j
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //nums[i] - rev(nums[i]) == nums[j] - rev(nums[j]) Equivalent solves the problem
        double MOD = Math.pow(10, 9) + 7;
        int n = nums.length; 
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int diff = nums[i] - getReverse(nums[i]);
            ans += map.getOrDefault(diff, 0);
            ans %= MOD;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return ans;

    }
    private int getReverse(int num){
        int rev = 0;
        while (num > 0){
            rev = 10 * rev + num % 10;
            num /= 10;
        }
        return rev;
    }
}
// @lc code=end

