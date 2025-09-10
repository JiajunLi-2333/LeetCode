/*
 * @lc app=leetcode id=3090 lang=java
 *
 * [3090] Maximum Length Substring With Two Occurrences
 */

// @lc code=start
class Solution {
    public int maximumLengthSubstring(String s) {
        char[] S = s.toCharArray(); 
        int n = S.length;
        int[] cnt = new int[26];
        int left = 0, ans = 0; 
        for(int right = 0; right < n; right++){
            char c = S[right];
            cnt[c - 'a']++;
            while(left < right && cnt[c - 'a'] > 2){
                cnt[S[left++] - 'a']--;
            }
            ans = Math.max(right - left +1, ans);
        }
        return ans;
    }
}
// @lc code=end

