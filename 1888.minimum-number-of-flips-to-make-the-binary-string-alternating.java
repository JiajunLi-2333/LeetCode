/*
 * @lc app=leetcode id=1888 lang=java
 *
 * [1888] Minimum Number of Flips to Make the Binary String Alternating
 */

// @lc code=start
class Solution {
    public int minFlips(String S) {
        // String s2 = s + s;
        // int One_pattern = 0;
        // int Zero_pattern = 0;
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0; i < s2.length(); i++){
        //     if(i % 2 == 0){// Even position
        //         if (s2.charAt(i) == '0') One_pattern++;
        //         else Zero_pattern++;
        //     }
        //     else{
        //         if(s2.charAt(i) == '0') Zero_pattern++;
        //         else One_pattern++;
        //     }

        //     if(i < s.length() -1) continue;
        //     ans = Math.min(ans, Math.min(One_pattern, Zero_pattern));
        //     int j = i - s.length() + 1;
        //     if(j % 2 == 0){
        //         if (s2.charAt(i - s.length() + 1) == '0') One_pattern--;
        //         else Zero_pattern--;
        //     }
        //     else{
        //         if(s2.charAt(i - s.length() + 1) == '0') Zero_pattern--;
        //         else One_pattern--;
        //     }
        // }
        // return ans; 

        //! solid thinking and systematic knowledgebase are the key to leetcode
        
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = n;
        int cnt = 0;
        for(int i = 0; i < 2*n - 1; i++){
            if(s[i % n] % 2 != i % 2) cnt++;
            int left = i - n + 1;
            if(left < 0) continue;
            ans = Math.min(ans, Math.min(cnt, n - cnt));
            if(s[left] % 2 != left % 2) cnt--;
        }
        return ans;
    }
}
// @lc code=end

