/*
 * @lc app=leetcode id=1498 lang=java
 *
 * [1498] Number of Subsequences That Satisfy the Given Sum Condition
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[] pow2 = new int[100_000];
    private static boolean initialized = false;
    private void initialize() {
        if (initialized) return;
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        initialized = true;
    }

    public int numSubseq(int[] nums, int target) {
        initialize();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
// @lc code=end

