/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 */

// @lc code=start
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0; 
        for(String w : words){
            if(check(s, w)) ans++;
        }
        return ans;
    }
    private boolean check(String S, String W){
        int n = S.length();
        int m = W.length();
        //1. length check
        if(m > n) return false;

        int left = 0, right = 0;
        while(left < n && right < m){
            char cS = S.charAt(left);
            char cW = W.charAt(right);
            if(cS != cW) return false;
            int cntS = 1;
            while(left < n - 1 && S.charAt(left) == S.charAt(left + 1)){
                cntS++;
                left++;
            }
            int cntW = 1;
            while(right < m - 1 && W.charAt(right) == W.charAt(right + 1)){
                cntW++;
                right++;
            }
            if(cntS < cntW) return false;
            if(cntS != cntW && cntS < 3) return false;
            left++;
            right++;
        }
        return left == n && right == m;
    }
}
// @lc code=end

