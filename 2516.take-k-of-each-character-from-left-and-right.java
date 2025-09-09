/*
 * @lc app=leetcode id=2516 lang=java
 *
 * [2516] Take K of Each Character From Left and Right
 */
// @lc code=start
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] cnt = new int[3];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++; 
        }
        if(cnt[0] < k || cnt[1] < k || cnt[2] < k) return -1;
        if(k == 0) return 0;
        
        int left = 0, ans = n, len = 0;
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            cnt[c - 'a']--;
            while(left <= right && cnt[c - 'a'] < k){
                cnt[s.charAt(left) - 'a']++;
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return ans - len;
    }
}
// @lc code=end

