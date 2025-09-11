/*
 * @lc app=leetcode id=2038 lang=java
 *
 * [2038] Remove Colored Pieces if Both Neighbors are the Same Color
 */

// @lc code=start
class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aCnt = 0, bCnt = 0;
        int left = 0, right = 0;
        while(right < n){
            while(right < n && colors.charAt(left) == colors.charAt(right)){
                right++;
            }
            int len = right - left;
            if(colors.charAt(left) == 'A'){
                aCnt += Math.max(0, len - 2);
            } else {
                bCnt += Math.max(0, len - 2);
            }
            left = right;
        }
        return aCnt > bCnt;
    }
}
// @lc code=end

