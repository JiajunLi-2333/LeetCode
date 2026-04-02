/*
 * @lc app=leetcode id=2931 lang=java
 *
 * [2931] Maximum Spending After Buying Items
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] a = new int[m *n];
        for(int i = 0; i < m; i++){
            System.arraycopy(values[i], 0, a, i * n, n);
        }
        Arrays.sort(a);

        long ans = 0;
        for(int i = 0; i < a.length; i++){
            ans += (i + 1) * (long) a[i];
        }
        return ans;
    }
}
// @lc code=end

