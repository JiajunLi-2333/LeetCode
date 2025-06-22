/*
 * @lc app=leetcode id=2559 lang=java
 *
 * [2559] Count Vowel Strings in Ranges
 */

// @lc code=start
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        String vowels = "aeiou";
        int[] preSum = new int[n + 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if(vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length()-1)) != -1){
                preSum[i + 1] = preSum[i]  +1;
            }
            else{
                preSum[i + 1 ] = preSum[i];
            }
        }
        for(int i = 0; i < queries.length; i++){
            ans[i] = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
        }
        return ans;

    }
}
// @lc code=end

