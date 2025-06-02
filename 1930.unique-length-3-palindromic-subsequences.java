/*
 * @lc app=leetcode id=1930 lang=java
 *
 * [1930] Unique Length-3 Palindromic Subsequences
 */

// @lc code=start
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> Uniq = new HashSet<>();
        for (char c : s.toCharArray()){
            Uniq.add(c);
        }
        for(char c : Uniq){
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if (first < last) {
                Set<Character> middleChars = new HashSet<>();
                for (int i = first + 1; i < last; i++) {
                    middleChars.add(s.charAt(i));
                }
                ans += middleChars.size();
            }
        }
        return ans;

    }
}
// @lc code=end

