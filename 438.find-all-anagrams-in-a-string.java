/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */
import java.util.ArrayList;
import java.util.List;
// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] anagram = new int[26];
        int plen = p.length();
        int slen = s.length();
        if(slen < plen){
            return result;
        }
        for(int i = 0; i < plen; i++){
            anagram[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < slen; i++){
            anagram[s.charAt(i) - 'a']--;
            if(i < plen -1){
                continue;
            }
            if(check(anagram)){
                result.add(i - plen + 1);
            }
            anagram[s.charAt(i - plen + 1) - 'a']++;
        }
        return result; 
    }
    private boolean check(int[] perm){
        for(int i = 0; i < 26; i++){
            if(perm[i] != 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

