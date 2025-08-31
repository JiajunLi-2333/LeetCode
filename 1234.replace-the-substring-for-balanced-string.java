/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        //正难则反： 观察剩余主体 --> 题目条件的分析方法
        char[] chars = s.toCharArray(); 
        int[] cnt = new int['X'];
        for(char c : chars){
            cnt[c]++;
        }
        
        int n = s.length();
        int m = n / 4;
        if(cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for(int i = 0; i < n; i++){
            cnt[chars[i]]--;
            while(cnt['Q'] <=m && cnt['W'] <=m && cnt['E'] <=m && cnt['R'] <=m){
                ans = Math.min(ans, i - left + 1);
                cnt[chars[left]]++;
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}
// @lc code=end

