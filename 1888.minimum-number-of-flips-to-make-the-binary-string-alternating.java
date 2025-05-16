/*
 * @lc app=leetcode id=1888 lang=java
 *
 * [1888] Minimum Number of Flips to Make the Binary String Alternating
 */

// @lc code=start
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s += s; // Concatenate the string to simulate the TYPE 1 operation
        int res = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            //! substring takes too much time, optimize by sliding window
            // int cnt_one = numFlips(s.substring(i, i + n), target_one);
            // int cnt_zero = numFlips(s.substring(i, i + n), target_zero);
            // res = Math.min(res, Math.min(cnt_one, cnt_zero));

            //todo sliding window

        }
        return res;
    }
}
// @lc code=end

