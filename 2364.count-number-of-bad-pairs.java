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
        // i < j and nums[j] - j != nums[i] - i
        int n = nums.length;
        long ans = (long) n * (n - 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int key = nums[i] - i;
            int cnt = map.getOrDefault(key, 0);
            ans -= cnt;
            map.put(key, cnt + 1);
        }
        return ans;

    }
}
// @lc code=end

