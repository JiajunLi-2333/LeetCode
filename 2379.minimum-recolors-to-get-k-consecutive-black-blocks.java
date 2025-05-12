/*
 * @lc app=leetcode id=2379 lang=java
 *
 * [2379] Minimum Recolors to Get K Consecutive Black Blocks
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        int n = blocks.length();
        int black = 0;
        for(int i = 0; i < n; i++){
            if(blocks.charAt(i) == 'B'){
                black++;
            }
            if(i >= k - 1){
                result = Math.min(result, k - black);
                if(blocks.charAt(i - k + 1) == 'B'){
                    black--;
                }

            }
        }
        return result;
    }
}
// @lc code=end

