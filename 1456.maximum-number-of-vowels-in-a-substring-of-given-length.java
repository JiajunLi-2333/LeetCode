/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int tmp = 0;
        String vowels = "aeiou";
        for(int i = 0; i < s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                tmp++;
            }
            if(i >= k){
                if(vowels.indexOf(s.charAt(i - k)) != -1){
                    tmp--;
                }
            }
            maxVowels = Math.max(maxVowels, tmp);
        }
        return maxVowels;
    }
}
// @lc code=end

