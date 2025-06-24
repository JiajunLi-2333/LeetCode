/*
 * @lc app=leetcode id=1744 lang=java
 *
 * [1744] Can You Eat Your Favorite Candy on Your Favorite Day?
 */

// @lc code=start
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        //1 <= amount eat per day <= dailyCap
        int n = candiesCount.length, m = queries.length;
        long[] preSum = new long[n + 1];
        boolean[] ans = new boolean[m];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + candiesCount[i];
        }
        for(int i = 0; i < m; i++){
            int favType = queries[i][0], favDay = queries[i][1], dailyCap = queries[i][2];
            Long min = (long) (favDay + 1)* 1;
            long max = (long) (favDay + 1)*dailyCap;
            long total = preSum[favType + 1];
            ans[i] = !(total < min || preSum[favType] >= max);
        }
        return ans;
    }
}
// @lc code=end

