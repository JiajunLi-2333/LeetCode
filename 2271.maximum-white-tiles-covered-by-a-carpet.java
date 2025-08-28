/*
 * @lc app=leetcode id=2271 lang=java
 *
 * [2271] Maximum White Tiles Covered by a Carpet
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int n = tiles.length, left = 0, right = 0, sum = 0, ans = 0;
        while(left <= right && right < n){
            //initialize the carpet end points
            int leftBound = tiles[left][0], rightBound = leftBound + carpetLen -1;
            
            if(tiles[right][1] <= rightBound){
                sum += tiles[right][1] - tiles[right][0] + 1;
                right++;
                ans = Math.max(sum, ans);
            }
            else{
                if(rightBound >= tiles[right][0]){
                    ans = Math.max(sum + rightBound - tiles[right][0] + 1, ans);
                }
                sum -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end

