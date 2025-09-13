/*
 * @lc app=leetcode id=1759 lang=java
 *
 * [1759] Count Number of Homogenous Substrings
 */

// @lc code=start
class Solution {
    public int countHomogenous(String s) {
        //枚举 + 双指针：分组循环
        long mod = (long)1e9 + 7;
        long ans = 0;
        int n = s.length(), left = 0, right = 0;
        while(right < n){
            while(right < n - 1 && s.charAt(right) == s.charAt(right + 1)){
                right++;
            }
            long len = right - left + 1;
            ans = (ans + (len * (1 + len) /2) % mod) % mod;
            right++;
            left = right;
        }
        return ans < 0 ? (int)(ans + mod) : (int)ans;
    }
}
// @lc code=end

