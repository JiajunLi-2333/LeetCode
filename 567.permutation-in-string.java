/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // int n1 = s1.length();
        // int n2 = s2.length();
        // boolean ans = false;
        // int[] perm = new int[26];
        // if(n1 > n2){
        //     return ans;
        // }
        // for(int i = 0; i < n1;i++){
        //     perm[s1.charAt(i) - 'a']++;
        // }
        // for(int i = 0; i < n2; i++){
        //     perm[s2.charAt(i) - 'a']--;
        //     if(i < n1 -1){
        //         continue;
        //     }
        //     if(check(perm)){
        //         ans = true;
        //         break;
        //     }
        //     perm[s2.charAt(i - n1 + 1) - 'a']++;
        // }
        // return ans; 
        int n1 = s1.length();
        int n2 = s2.length();
        int[] cnt = new int[26];
        if(n1 > n2){
            return false;
        }
        for(int i = 0; i < n1; i++){
            cnt[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < n2; i++){
            char c = s2.charAt(i);
            cnt[c - 'a']--;
            if(i < n1-1){
                continue;
            }
            if(check(cnt)){
                return true;
            }
            cnt[s2.charAt(i - n1 + 1) - 'a']++;
        }
        return false;
    }
    private boolean check(int[] perm){
        for(int i = 0; i < perm.length; i++){
            if(perm[i] != 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

