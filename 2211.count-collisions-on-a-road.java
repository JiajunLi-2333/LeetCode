/*
 * @lc app=leetcode id=2211 lang=java
 *
 * [2211] Count Collisions on a Road
 */

// @lc code=start
class Solution {
    public int countCollisions(String directions) {
        directions = directions.replaceAll("^L+", "");
        directions = new StringBuilder(directions).reverse().toString().replaceAll("^R+", "");
        int ans = 0;
        for(char c : directions.toCharArray()){
            if(c != 'S'){
                ans++;
            }
        }
        return ans;

    }
}
// @lc code=end

