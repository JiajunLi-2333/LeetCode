/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int empty = cnt.length;
        int ans = 0;
        int left = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            char cur = c[i];
            if(cnt[cur - 'a'] == 0){
                empty--;
            }
            cnt[cur - 'a']++;
            while(empty == 0){
                cnt[c[left] - 'a']--;
                if(cnt[c[left] - 'a'] == 0){
                    empty++;
                }
                left++;
            }
            //直接加上left就行了
            ans += left;

        }
        return ans;
    }
}
// @lc code=end

