/*
 * @lc app=leetcode id=3413 lang=java
 *
 * [3413] Maximum Coins From K Consecutive Bags
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> a[0] - b[0]);
        return Math.max(getMaxCoinsAlignLeft(coins, k), getMaxCoinsAlignRight(coins, k));
    }

    private long getMaxCoinsAlignLeft(int[][] coins, int k){
        long ans = 0, sum = 0;
        int left = coins.length - 1;  // 重新初始化左指针（实际是右指针）
        int r = left;             // 滑动窗口右边界
        
        // 从右向左遍历
        for (int i = left; i >= 0; i--) {
            int pocketRight = coins[i][0] + k - 1;  // 计算当前选择对应的右端点
            sum += (long)coins[i][2] * (coins[i][1] - coins[i][0] + 1);  // 将当前袋子完整加入总和
            
            // 调整右边界，移除完全不在选择范围内的袋子
            while (coins[r][0] > pocketRight) {
                sum -= (long)coins[r][2] * (coins[r][1] - coins[r][0] + 1);
                r--;
            }
            
            // 计算右边界袋子中可能部分不在选择范围内的硬币数量
            long extra = (long)Math.max(coins[r][1] - pocketRight, 0) * coins[r][2];
            
            // 更新最大硬币数量
            ans = Math.max(ans, sum - extra);
        }
        
        return ans;
    }

    private long getMaxCoinsAlignRight(int[][] coins, int k){
        long ans = 0, cover = 0;
        int left = 0;
        for(int[] coin : coins){
            int l = coin[0], r = coin[1], c = coin[2];
            cover += (long) c * (r - l + 1);
            int kLeft = r - k + 1;
            while(coins[left][1] < kLeft){
                cover -= (long) coins[left][2] * (coins[left][1] - coins[left][0] + 1);
                left++;
            }

            long uncover = Math.max((long) (kLeft - coins[left][0]) * coins[left][2], 0 );
            ans = Math.max(ans, cover - uncover);
        }
        return ans;
    }

}
// @lc code=end


