/*
 * @lc app=leetcode id=1124 lang=java
 *
 * [1124] Longest Well-Performing Interval
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        //! very challenging problem to solve
        int n = hours.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (hours[i] > 8 ? 1 : -1);
        }

        int maxLength = 0;
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (!firstOccurrence.containsKey(prefixSum[i])) {
                firstOccurrence.put(prefixSum[i], i);
            }
            if (prefixSum[i] > 0) {
                maxLength = Math.max(maxLength, i);
            } else if (firstOccurrence.containsKey(prefixSum[i] - 1)) {
                maxLength = Math.max(maxLength, i - firstOccurrence.get(prefixSum[i] - 1));
            }
        }
        return maxLength;
    }
}
// @lc code=end

