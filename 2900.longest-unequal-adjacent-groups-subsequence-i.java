/*
 * @lc app=leetcode id=2900 lang=java
 *
 * [2900] Longest Unequal Adjacent Groups Subsequence I
 */
import java.util.ArrayList;
// @lc code=start
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = groups.length;
        for(int i = 0;i < n; i++){
            if(i == n -1 || groups[i] != groups[i + 1]){
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
// @lc code=end

