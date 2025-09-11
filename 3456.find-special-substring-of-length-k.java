/*
 * @lc app=leetcode id=3456 lang=java
 *
 * [3456] Find Special Substring of Length K
 */

// @lc code=start
class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        boolean ans = false;
        int left = 0; 
        int n = s.length();
        int right = 0;
        while(right < n ){
            while (right + 1 < n && s.charAt(right + 1) == s.charAt(right)) {
                right++;
            }
            // 判断窗口长度
            if (right - left + 1 == k) {
                return true;
            }
            // 移动到下一个窗口
            right++;
            left = right;
        }
        return ans;
    }
}
// @lc code=end

