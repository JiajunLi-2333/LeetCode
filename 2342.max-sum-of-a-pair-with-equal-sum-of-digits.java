/*
 * @lc app=leetcode id=2342 lang=java
 *
 * [2342] Max Sum of a Pair With Equal Sum of Digits
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num: nums){
            int sum = digitSum(num);
            if (map.containsKey(sum)){
                ans = Math.max(ans, map.get(sum) + num);
            }
            map.merge(sum, num, Integer::max);
        }
        return ans;
    }


    private int digitSum(int n){
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

